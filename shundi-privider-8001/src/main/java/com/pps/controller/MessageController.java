package com.pps.controller;

import com.pps.MyLog;
import com.pps.pojo.group.MessageType;
import com.pps.pojo.group.Result;
import com.pps.pojo.mongo.TemporaryStorage;
import com.pps.service.UserService;
import com.pps.util.MessageUtil;
import com.pps.util.UUIDUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Classname MessageController
 * @Description
 * @@Author Pupansheng
 * @Date 2019/10/9 9:12
 * @Vestion 1.0
 **/
@RestController
@RequestMapping("/message")
@Api("这是短信发送模块")
public class MessageController {

    @Autowired
    private UserService userService;
    @Autowired
    private MessageUtil messageUtil;
    @Autowired
    private MongoTemplate mongoTemplate;




    @ApiOperation(value="给电话号码发送验证码", notes="根据不同类型发送不同类型验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "电话号码", required = true, dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "type", value = "验证码类型 值可以为：注册验证：register 登录验证：login 更新个人信息：update", required = true, dataType = "String",paramType = "path")
    })

    @GetMapping("/getYanzhengma/{phone}/{type}")
    public Result getYanzhengma(@PathVariable("phone") String phone, @PathVariable("type") String type){
        Result result = new Result();
        String yanzhengma = String.valueOf(UUIDUtil.getNumber(5));
        boolean f=false;


        if (type.equals("register"))
            f = messageUtil.sendMessage(MessageType.SMS_152441016.toString(), yanzhengma, phone);
        if (type.equals("login"))
            f = messageUtil.sendMessage(MessageType.SMS_152441018.toString(), yanzhengma, phone);
        if(type.equals("update"))
            f=messageUtil.sendMessage(MessageType.SMS_152441019.toString(),yanzhengma,phone);


        if(f) {


            if (type.equals("register")) {

                //查询手机号是否已被注册


                MyLog.logger.info("产生register验证码:" + yanzhengma);

                //删除此前存在的
                String key=phone+type;
                Query query=new Query();
                Criteria criteria = Criteria.where("key").is(key);
                query.addCriteria(criteria);
                mongoTemplate.remove(query, "shundiStorage");



                //存入 mongodb 60s
                TemporaryStorage temporaryStorage=new TemporaryStorage();
                temporaryStorage.setKey(phone+type);
                temporaryStorage.setData(yanzhengma);
                temporaryStorage.setSaveDate(new Date());

                mongoTemplate.save(temporaryStorage);


            }
            if (type.equals("login")) {

                MyLog.logger.info("产生login验证码:" + yanzhengma);

                //首先从库里看看有没有以前的
                //删除此前存在的
                String key=phone+type;
                Query query=new Query();
                Criteria criteria = Criteria.where("key").is(key);
                query.addCriteria(criteria);
                mongoTemplate.remove(query, "shundiStorage");






                //存入 mongodb 60s
                TemporaryStorage temporaryStorage=new TemporaryStorage();
                temporaryStorage.setKey(phone+type);
                temporaryStorage.setData(yanzhengma);
                temporaryStorage.setSaveDate(new Date());

                mongoTemplate.save(temporaryStorage);


            }
            if (type.equals("update")) {

                MyLog.logger.info("产生update验证码:" + yanzhengma);

                //删除此前存在的
                String key=phone+type;
                Query query=new Query();
                Criteria criteria = Criteria.where("key").is(key);
                query.addCriteria(criteria);
                mongoTemplate.remove(query, "shundiStorage");




                //存入 mongodb 60s
                TemporaryStorage temporaryStorage=new TemporaryStorage();
                temporaryStorage.setKey(phone+type);
                temporaryStorage.setData(yanzhengma);
                temporaryStorage.setSaveDate(new Date());

                mongoTemplate.save(temporaryStorage);

            }
            result.setStatus(true);

        }
        else
            result.setStatus(false);




        return  result;

    }








}
