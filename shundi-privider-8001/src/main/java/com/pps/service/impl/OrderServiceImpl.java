package com.pps.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mongodb.WriteResult;
import com.pps.mapper.TbOrderMapper;
import com.pps.pojo.TbOrder;
import com.pps.pojo.TbOrderExample;
import com.pps.pojo.exception.UnknowException;
import com.pps.pojo.group.Result;
import com.pps.pojo.mongo.UserPoint;
import com.pps.pojo.status.OrderStatus;
import com.pps.pojo.status.PackageStatus;
import com.pps.service.OrderService;
import com.pps.service.UserPointService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @Classname OrderServiceImpl
 * @Description
 * @@Author Pupansheng
 * @Date 2019/12/15 18:05
 * @Vestion 1.0
 **/
@Transactional
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    TbOrderMapper tbOrderMapper;
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    UserPointService userPointService;


    @Override
    public TbOrder addOrder(TbOrder tbOrder) {

        UserPoint userPoint = userPointService.getUserPoint(tbOrder.getUserpointid());
        int status=userPoint.getStatus();
        if(status!=PackageStatus.已提交.getCode()){
            throw new UnknowException("该货物此状态不可接单 请刷新页面 信息存在滞后");
        }

        tbOrder.setStatus(OrderStatus.已申请.getCode());
        tbOrderMapper.insert(tbOrder);
        Optional.of(tbOrder.getId()).orElseThrow(UnknowException::new);

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(userPoint.get_id()));  //_id区分引号 "1"和1
        Update update = Update.update("status", PackageStatus.已申请.getCode());
        mongoTemplate.updateFirst(query,update,"userPoint");
        return  tbOrder;

    }

    @Override
    public Optional<Boolean> updateOrder(TbOrder tbOrder) {

        int i = tbOrderMapper.updateByPrimaryKeySelective(tbOrder);

        if(i >1) {
            throw  new UnknowException("更新订单失败");
        };

          return  Optional.of(true);
    }

    @Override
    public Boolean deleteOrder(TbOrder tbOrder) {

        int status = tbOrder.getStatus();
        if(status==OrderStatus.已申请.getCode()||status==OrderStatus.被拒绝.getCode()){

            if(status==OrderStatus.已申请.getCode()){

                Query query = new Query();
                query.addCriteria(Criteria.where("_id").is(tbOrder.getUserpointid()));  //_id区分引号 "1"和1
                Update update = Update.update("status", PackageStatus.已提交.getCode());
                WriteResult userPoint1 = mongoTemplate.updateFirst(query, update, "userPoint");


            }
            int c=  tbOrderMapper.deleteByPrimaryKey(tbOrder.getId());
            if(c>1){
                throw new UnknowException("删除失败");
            }
            return  Optional.of(c==1).get();

        }else{
            throw  new UnknowException("该状态下不可以改变其状态");
        }
    }

    @Override
    public TbOrder findOrderById(Integer id) {

     return     tbOrderMapper.selectByPrimaryKey(id);

    }

    @Override
    public PageInfo findByCondition(TbOrder tbOrder,Integer pageNum,Integer pageSize) {
         if(pageNum==null) {
             pageNum=1;
         }
         if(pageSize==null){
             pageSize=10;
         }
        TbOrderExample tbOrderExample=new TbOrderExample();
        TbOrderExample.Criteria criteria = tbOrderExample.createCriteria();

        if(tbOrder.getId()!=null){

            criteria.andIdEqualTo(tbOrder.getId());
        }
        if(tbOrder.getOwnerid()!=null){

            criteria.andOwneridEqualTo(tbOrder.getOwnerid());
        }
        if(tbOrder.getUserid()!=null){

            criteria.andUseridEqualTo(tbOrder.getUserid());
        }
        if(tbOrder.getUserpointid()!=null){

            criteria.andUserpointidEqualTo(tbOrder.getUserpointid());
        }
        if(tbOrder.getStatus()!=null){
            criteria.andStatusEqualTo(tbOrder.getStatus());
        }
        PageHelper.startPage(pageNum,pageSize);
        List<TbOrder> tbOrders = tbOrderMapper.selectByExample(tbOrderExample);
        PageInfo pageInfo = new PageInfo<>(tbOrders);

        return pageInfo;
    }

    @Override
    public Result getOrderNum(Integer userId) {

        HashMap hashMap=new HashMap();
        OrderStatus[] values = OrderStatus.values();
        Arrays.stream(values).forEach(p->{

            Integer code = p.getCode();
            TbOrderExample tbOrderExample=new TbOrderExample();
            TbOrderExample.Criteria criteria = tbOrderExample.createCriteria();
            criteria.andStatusEqualTo(code);
            criteria.andUseridEqualTo(userId);
            int count = tbOrderMapper.countByExample(tbOrderExample);
            hashMap.put(code+"",count);
        });

        return  new Result(true,hashMap);




    }
}
