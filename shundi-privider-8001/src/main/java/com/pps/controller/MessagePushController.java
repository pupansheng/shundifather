package com.pps.controller;

import com.alibaba.fastjson.JSONObject;
import com.pps.config.compont.HuanXinHelper;
import com.pps.pojo.group.Result;
import com.pps.service.PushService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname MessagePushController
 * @Description 系统推送控制
 * @@Author Pupansheng
 * @Date 2020/1/28 14:42
 * @Vestion 1.0
 **/
@Api("这是短信发送模块")
@RestController
@RequestMapping("/talk")
public class MessagePushController {

    @Autowired
    PushService pushService;

    @ApiOperation(value = "推送给所有的人信息", notes = "")
    @PostMapping("/push/add")
    public Result pushMessage(@RequestBody JSONObject jsonObject){


        return  pushService.sendAll(jsonObject);

    }

    @ApiOperation(value = "推送给固定人信息", notes = "")
    @PostMapping("/push/one")
    public  Result  pushMessageOne(@RequestBody JSONObject jsonObject){


     return  pushService.sendOne(jsonObject);

    }











}
