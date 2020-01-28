package com.pps.controller;

import com.pps.MyLog;
import com.pps.pojo.TbUser;
import com.pps.pojo.group.Result;
import com.pps.pojo.mongo.UserPoint;
import com.pps.service.PayService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.krb5.KdcComm;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Classname PayController
 * @Description 支付
 * @@Author Pupansheng
 * @Date 2020/1/9 17:09
 * @Vestion 1.0
 **/
@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private PayService payService;
    @ApiOperation("获取订单数据")
    @PostMapping("/getOrder")
    public Result getOrderInfo(@RequestBody UserPoint userPoint){

        return  payService.getOrderInfo(userPoint);
    }
    @ApiOperation("支付成功回调")
    @RequestMapping("/success")
    public Result success(String orderId){
        MyLog.logger.info("支付成功--------------------------------");

        return payService.paySuccess(orderId);
       /* Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        parameterMap.forEach((K,V)->{
            MyLog.logger.info(K+":");
            String s = Arrays.stream(V).collect(Collectors.joining(",")).toString();
           MyLog.logger.info(s);
        });
        MyLog.logger.info("结束--------------------------------");*/


    }
    @ApiOperation("支付回调")
    @PostMapping("/notify")
    public void notifiy(HttpServletRequest httpServletRequest){
        MyLog.logger.info("支付回调-------------------------------参数如下");
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        parameterMap.forEach((K,V)->{
            MyLog.logger.info(K+":");
            String s = Arrays.stream(V).collect(Collectors.joining(",")).toString();
            MyLog.logger.info(s);
        });
        MyLog.logger.info("结束--------------------------------");
    }






}
