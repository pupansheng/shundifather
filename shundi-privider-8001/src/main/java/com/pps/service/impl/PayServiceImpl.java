package com.pps.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.pps.MyLog;
import com.pps.config.compont.PayConfig;
import com.pps.mapper.TbOrderMapper;
import com.pps.mapper.TbPayMapper;
import com.pps.mapper.TbUserMapper;
import com.pps.pojo.TbOrder;
import com.pps.pojo.TbOrderExample;
import com.pps.pojo.TbPay;
import com.pps.pojo.TbUser;
import com.pps.pojo.exception.UnknowException;
import com.pps.pojo.group.Result;
import com.pps.pojo.mongo.UserPoint;
import com.pps.pojo.status.OrderStatus;
import com.pps.pojo.status.PackageStatus;
import com.pps.pojo.status.PayStatus;
import com.pps.service.OrderService;
import com.pps.service.PayService;
import com.pps.service.UserPointService;
import com.pps.service.UserService;
import com.pps.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Classname PayServiceImpl
 * @Description
 * @@Author Pupansheng
 * @Date 2020/1/9 17:12
 * @Vestion 1.0
 **/
@Service
@Transactional
public class PayServiceImpl implements PayService {

    @Autowired
    TbOrderMapper tbOrderMapper;
    @Autowired
    TbPayMapper tbPayMapper;
    @Autowired
    TbUserMapper tbUserMapper;
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    UserPointService userPointService;
    @Autowired
    PayConfig payConfig;

    @Override
    public Result getOrderInfo(UserPoint userPoint) {


        TbOrderExample tbOrderExample=new TbOrderExample();
        TbOrderExample.Criteria criteria= tbOrderExample.createCriteria();
        criteria.andUserpointidEqualTo(userPoint.get_id());
        List<TbOrder> tbOrders=tbOrderMapper.selectByExample(tbOrderExample);
        if(tbOrders.size()<=0){
            throw new UnknowException("该订单不存在 请刷新");
        }
        TbOrder tbOrder = tbOrders.get(0);

        int status = tbOrder.getStatus();
        if(status!= OrderStatus.待支付.getCode()){

            throw new UnknowException("该订单此状态不可进行此操作 请刷新");
        }
       UserPoint userPoint1=userPointService.getUserPoint(userPoint.get_id());
       Double money=userPoint1.getMoney();
       int status2=userPoint1.getStatus();
       if(status2!= PackageStatus.待支付.getCode()){
           throw new UnknowException("该订单此状态不可进行此操作 请刷新");
       }

        TbPay tbPay=new TbPay();


        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient(payConfig.getServerUrl(), payConfig.getAppId(), payConfig.getPrivate_key(), payConfig.getFormate(),payConfig.getEncoding(),payConfig.getPublic_key(),payConfig.getSignType());
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
       //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody(userPoint1.getGoods().getName());
        model.setSubject("顺递");
        String orderID= String.valueOf(new IdWorker().nextId());

        tbPay.setId(orderID);
        tbPay.setCreatetime(new Date());

        model.setOutTradeNo(orderID);
        model.setTimeoutExpress("30m");
        model.setTotalAmount(String.valueOf(new BigDecimal(tbOrder.getTalkprice())));
        model.setProductCode(tbOrder.getUserpointid());
        request.setBizModel(model);
        request.setNotifyUrl(payConfig.getNotifyUrl());

        tbPay.setPrice(tbOrder.getTalkprice());
        tbPay.setBk1(tbOrder.getOwnerid().toString());//物主
        tbPay.setBk2(tbOrder.getUserid().toString());//运货手
        tbPay.setContent(JSON.toJSONString(tbOrder));
        MyLog.logger.info("订单参数如下："+JSON.toJSONString(model));
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            MyLog.logger.info("支付宝响应如下："+response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
            MyLog.logger.info("申请订单信息成功----存入数据库tb_pay");
            tbPay.setStatus(PayStatus.未支付.getCode());
            int i = tbPayMapper.insertSelective(tbPay);
            if(i!=1){

                throw  new UnknowException("支付请求失败！");

            }
            return  new Result(true,orderID,response.getBody());

        } catch (AlipayApiException e) {
            e.printStackTrace();
            throw new UnknowException("支付发生错误");
        }
    }

    @Override
    public Result paySuccess(String orderId) {

        TbPay tbPay = tbPayMapper.selectByPrimaryKey(orderId);
        if(tbPay==null){
            throw  new UnknowException("该订单不存在");
        }
        tbPay.setStatus(PayStatus.已支付.getCode());
        int i = tbPayMapper.updateByPrimaryKey(tbPay);
        if(i!=1){
            throw new UnknowException("更新订单失败");
        }
        String content = tbPay.getContent();
        TbOrder tbOrder = JSON.parseObject(content, TbOrder.class);
        Integer userid = tbOrder.getUserid();
        String userpointid = tbOrder.getUserpointid();
        tbOrder.setStatus(OrderStatus.交易完成.getCode());

        //更新订单信息
        tbOrderMapper.updateByPrimaryKey(tbOrder);

        UserPoint userPoint = userPointService.getUserPoint(userpointid);
        int status=userPoint.getStatus();
        if(status!=PackageStatus.待支付.getCode()){
            throw  new UnknowException("该订单状态 不可进行此操作");
        }
        //更新物主订单信息
        userPointService.updateStatus(userPoint,PackageStatus.交易完成.getCode());

        //更新接货人的余额

        TbUser data =(TbUser) tbUserMapper.selectByPrimaryKey(userid);
        BigDecimal money = data.getMoney();
        if(money==null){
            money=new BigDecimal(0);
        }
        data.setMoney(new BigDecimal(tbOrder.getTalkprice()).add(money));
        data.setLerver(data.getLerver()!=null?data.getLerver():0+1);
        Result update = userService.update(data);
        if(!update.isStatus()){
            throw  new UnknowException("更新接单人金额失败");
        }



        return new Result(true,null);
    }
}
