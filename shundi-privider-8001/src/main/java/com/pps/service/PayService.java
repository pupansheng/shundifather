package com.pps.service;

/*
 * @Author Pupansheng
 * @Description // 支付接口
 * @Date 17:11 2020/1/9
 * @Param
 * @return
 **/

import com.pps.pojo.group.Result;
import com.pps.pojo.mongo.UserPoint;

public interface PayService {

    /*
     * @Author Pupansheng
     * @Description // 得到支付订单数据
     * @Date 17:12 2020/1/9
     * @Param
     * @return
     **/
    Result getOrderInfo(UserPoint userPoint);


    Result paySuccess(String orderId);
}
