package com.pps.service;
/*
 * @Author Pupansheng
 * @Description // 推送信息
 * @Date 14:45 2020/1/28
 * @Param
 * @return
 **/

import com.pps.pojo.group.Result;

import java.util.Map;

public interface PushService {
    /*
     * @Author Pupansheng
     * @Description // 推送给所有用户
     * @Date 14:46 2020/1/28
     * @Param
     * @return
     **/

     public Result  sendAll(Map m);


    /*
     * @Author Pupansheng
     * @Description // 推送给单一用户
     * @Date 14:46 2020/1/28
     * @Param
     * @return
     **/
     public  Result sendOne(Map map);

}
