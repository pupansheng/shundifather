package com.pps.controller;

import com.alibaba.fastjson.JSONObject;
import com.pps.MyLog;
import com.pps.pojo.group.Result;
import com.pps.pojo.mongo.TemporaryStorage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Classname ChatHistoryController
 * @Description
 * @@Author Pupansheng
 * @Date 2020/2/4 16:11
 * @Vestion 1.0
 **/

@RestController
@RequestMapping("/chatHistory")
public class ChatHistoryController {

    @Autowired
    MongoTemplate mongoTemplate;

    @ApiOperation(value = "保存聊天历史记录", notes = "")
    @PostMapping("/save")
    public Result saveMessage(@RequestBody JSONObject jsonObject){

       // MyLog.logger.info("保存历史纪录："+jsonObject);

        TemporaryStorage temporaryStorage=new TemporaryStorage();
        temporaryStorage.setId(jsonObject.getString("id"));
        temporaryStorage.setKey(jsonObject.getString("id"));
        temporaryStorage.setSaveDate(new Date());
        temporaryStorage.setData(jsonObject.getJSONArray("chatList"));

        try {
            mongoTemplate.save(temporaryStorage);
            return  new Result(true,null);
        }catch (Exception e){

        }

        return  new Result(false,"保存聊天记录失败");

    }

    @ApiOperation(value = "get聊天历史记录", notes = "")
    @PostMapping("/get")
    public Result getMessage(@RequestBody JSONObject jsonObject){

        String key=jsonObject.getString("id");
        Query query=new Query();
        Criteria criteria = Criteria.where("key").is(key);
        query.addCriteria(criteria);
        TemporaryStorage shundiStorage = mongoTemplate.findOne(query, TemporaryStorage.class, "shundiStorage");
        if(shundiStorage!=null) {
            return new Result(true,"", shundiStorage.getData());
        }else{
            return  new Result(true,null);
        }


    }

}
