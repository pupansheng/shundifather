package com.pps.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pps.mapper.TbOrderMapper;
import com.pps.pojo.TbOrder;
import com.pps.pojo.TbOrderExample;
import com.pps.pojo.exception.UnknowException;
import com.pps.pojo.mongo.UserPoint;
import com.pps.service.OrderService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    @Override
    public TbOrder addOrder(TbOrder tbOrder) {

        tbOrderMapper.insert(tbOrder);
        Optional.of(tbOrder.getId()).orElseThrow(UnknowException::new);
        //更新物品状态
    /*    UserPoint userPoint = mongoTemplate.findById(tbOrder.getUserpointid(), UserPoint.class, "userPoint");
        userPoint.setStatus(0);
        mongoTemplate.save(userPoint);*/

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(tbOrder.getUserpointid()));  //_id区分引号 "1"和1
        Update update = Update.update("status", "0");
        mongoTemplate.updateFirst(query,update,"userPoint");

        return  tbOrder;
    }

    @Override
    public Optional<Boolean> updateOrder(TbOrder tbOrder) {

        int i = tbOrderMapper.updateByPrimaryKeySelective(tbOrder);

        Boolean s = Optional.of(i == 1).orElseThrow(() -> {
            return new UnknowException("更新订单失败");
        });

          return  Optional.of(s);
    }

    @Override
    public Boolean deleteOrder(TbOrder tbOrder) {
      int c=  tbOrderMapper.deleteByPrimaryKey(tbOrder.getId());
      if(c>1){
          throw new UnknowException("删除失败");
      }
      return  Optional.of(c==1).get();
    }

    @Override
    public TbOrder findOrderById(Integer id) {

     return     tbOrderMapper.selectByPrimaryKey(id);

    }

    @Override
    public PageInfo findByCondition(TbOrder tbOrder,Integer pageNum,Integer pageSize) {

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
}
