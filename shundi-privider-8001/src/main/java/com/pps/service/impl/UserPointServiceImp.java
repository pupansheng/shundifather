package com.pps.service.impl;

import com.pps.MyLog;
import com.pps.pojo.group.Result;
import com.pps.pojo.mongo.UserPoint;
import com.pps.service.UserPointService;
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
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            mongoTemplate.remove(driverPoint);

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
    //    MyLog.logger.info("pageNum"+pageNum+"||pageSize"+pageSize+"||status"+status+"||userId"+userId);
        // 每页五个
        PageRequest request = new PageRequest(pageNum,pageSize);


       Query query1=query.with(request);

        // 排序
     //   query.with(new Sort(Sort.Direction.ASC,"createTime"));
        // 查询总数
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



}
