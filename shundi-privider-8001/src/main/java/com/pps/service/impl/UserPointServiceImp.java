package com.pps.service.impl;

import com.mongodb.WriteResult;
import com.pps.MyLog;
import com.pps.mapper.TbOrderMapper;
import com.pps.pojo.TbOrder;
import com.pps.pojo.TbOrderExample;
import com.pps.pojo.exception.UnknowException;
import com.pps.pojo.group.Result;
import com.pps.pojo.mongo.UserPoint;
import com.pps.pojo.status.OrderStatus;
import com.pps.pojo.status.PackageStatus;
import com.pps.service.UserPointService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @Classname UserPointServiceImp
 * @Description
 * @@Author Pupansheng
 * @Date 2019/10/10 10:58
 * @Vestion 1.0
 **/
@Transactional
@Service
public class UserPointServiceImp implements UserPointService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoOperations mongoOperations;
    @Autowired
    TbOrderMapper tbOrderMapper;



    @Override
    public Result saveUserPoint(UserPoint userPoint) {

        Result result=new Result();
        try {


           mongoTemplate.save(userPoint);
            result.setStatus(true);
            MyLog.logger.info("存入包裹："+userPoint);
            result.setData(userPoint);

        }catch (Exception e){

            result.setStatus(false);
            result.setMessage("保存失败");
            e.printStackTrace();
        }

        return  result;
    }

    @Override
    public Result deleteUserPoint(String _id) {

        Result result=new Result();
        try {

            UserPoint driverPoint=new UserPoint();

            driverPoint.set_id(_id);
            mongoTemplate.remove(driverPoint,"userPoint");

            result.setStatus(true);


        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(false);
            result.setMessage("删除错误");
        }
        return  result;
    }

    @Override
    public Result updateUserPont(UserPoint userPoint) {

        Result result=new Result();
        try {
            mongoTemplate.save(userPoint);
            result.setStatus(true);
        }catch (Exception e){

            result.setStatus(false);
            result.setMessage("");
        }
        return  result;
    }

    @Override
    public Result updateStatus(UserPoint userPoint,int status) {

        if(status==PackageStatus.无效.getCode()){

            UserPoint userPoint1 = getUserPoint(userPoint.get_id());
            if(!userPoint1.getStatus().equals(PackageStatus.已提交.getCode())){
                throw new UnknowException("该状态不可取消，信息存在延迟，请刷新信息");
            }

        }
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(userPoint.get_id()));  //_id区分引号 "1"和1
        Update update = Update.update("status", status);
        WriteResult userPoint1 = mongoTemplate.updateFirst(query, update, "userPoint");



        return new Result(true,null);
    }

    @Override
    public Result agreeOrReject(UserPoint userPoint, int status) {

        UserPoint userPoint1 = getUserPoint(userPoint.get_id());
        if(!userPoint1.getStatus().equals(PackageStatus.已申请.getCode())){
            throw new UnknowException("改物品状态已发生变化 操作非法 请刷新！");
        }

        TbOrderExample tbOrderExample=new TbOrderExample();
        TbOrderExample.Criteria criteria = tbOrderExample.createCriteria();
        criteria.andUserpointidEqualTo(userPoint.get_id());

        List<TbOrder> tbOrders = tbOrderMapper.selectByExample(tbOrderExample);
        if(tbOrders.size()<=0){
            throw new UnknowException("该订单已不存在 信息存在滞后 请刷新");
        }
        TbOrder tbOrder = tbOrders.get(0);

        if(status==OrderStatus.已同意.getCode()||status==OrderStatus.被拒绝.getCode()){
            tbOrder.setStatus(status);
            tbOrder.setTalkprice(userPoint.getMoney());
            int i = tbOrderMapper.updateByPrimaryKeySelective(tbOrder);
            if(i!=1){
                throw new UnknowException("更改订单信息失败");
            }
            if(status==OrderStatus.已同意.getCode()){
                updateStatus(userPoint,PackageStatus.进行中.getCode());
            }else{
                updateStatus(userPoint,PackageStatus.已提交.getCode());
            }

        }
        else{
            throw new UnknowException("操作非法 ");
        }

        return  new Result(true,null);
    }

    @Override
    public GeoResults<UserPoint> getNearUserPoint(Double lat, Double lng, Double minDistance, Double maxDistance) {

        Point location = new Point(lng,lat);
        NearQuery query = NearQuery.near(location).maxDistance(new Distance(maxDistance, Metrics.KILOMETERS));
        Query query1=new Query();
        Criteria criteria = Criteria.where("status").is(1);
        query1.addCriteria(criteria);
        query.query(query1);

        GeoResults<UserPoint> geoResults= mongoTemplate.geoNear(query, UserPoint.class,"userPoint");

        return  geoResults;

    }

    @Override
    public UserPoint getUserPoint(String id) {

        return    mongoTemplate.findById(id,UserPoint.class,"userPoint");
    }

    @Override
    public List<UserPoint> getUserPointsByUserId(String userId) {

        Query query=new Query();
        Criteria criteria = Criteria.where("user_id").is(userId);
        query.addCriteria(criteria);


        return  mongoTemplate.find(query,UserPoint.class,"userPoint");

    }

    @Override
    public Result getUserPointByUserIdWithPage(int pageNum, int pageSize, int status, int userId){

        Query query = new Query();
        query.addCriteria(Criteria.where("status").is(status));
        query.addCriteria(Criteria.where("user_id").is(userId+""));
        PageRequest request = new PageRequest(pageNum,pageSize);
        Query query1=query.with(request);

        int count = (int) mongoOperations.count(query1, "userPoint");
        List<UserPoint> userPoint = mongoOperations.find(query1, UserPoint.class, "userPoint");
      //  MyLog.logger.info("pageNum"+pageNum+"||pageSize"+pageSize+"||status"+status+"||userId"+userId+"dataSize="+userPoint.size()+"||count="+count);
        Page<UserPoint> page = PageableExecutionUtils.getPage(userPoint, request, () -> count);
        Map map=new HashMap();
        map.put("total",page.getTotalElements());
        map.put("pageCount",page.getTotalPages());
        map.put("list",page.getContent());
        Result result=new Result(true,map);
        return  result;
    }

    @Override
    public Result getPackageNum(Integer userId) {
        Map hashMap=new HashMap();
        PackageStatus[] values = PackageStatus.values();
        Arrays.stream(values).forEach(p->{

            Integer code = p.getCode();
            Query query = new Query();
            query.addCriteria(Criteria.where("status").is(code));
            query.addCriteria(Criteria.where("user_id").is(userId+""));
            int count = (int) mongoOperations.count(query, "userPoint");
            hashMap.put(code+"",count);
        });

        return  new Result(true,hashMap);
    }


}
