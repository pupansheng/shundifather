package com.pps.util;

import com.pps.MyLog;
import com.pps.pojo.group.Result;
import com.pps.pojo.mongo.TemporaryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @Classname MongodbUtil
 * @Description
 * @@Author Pupansheng
 * @Date 2019/11/24 12:22
 * @Vestion 1.0
 **/
@Service
public class MongodbUtil {

    @Autowired
    private MongoTemplate mongoTemplate;
    /*
     * @Author Pupansheng
     * @Description // 根据K和collection获得值
     * @Date 12:23 2019/11/24
     * @Param
     * @return
     **/
    public TemporaryStorage getDataByKey(String key,String collection){



        MyLog.logger.info("KEY="+key);
        Query query=new Query();
        Criteria criteria2 = Criteria.where("key").is(key);
        query.addCriteria(criteria2);
        TemporaryStorage tem = mongoTemplate.findAndRemove(query, TemporaryStorage.class, collection);


        return  tem;



    }
    public TemporaryStorage getDataByKey(String key){

        MyLog.logger.info("KEY="+key);
        Query query=new Query();
        Criteria criteria2 = Criteria.where("key").is(key);
        query.addCriteria(criteria2);
        TemporaryStorage tem = mongoTemplate.findOne(query, TemporaryStorage.class, "shundiStorage");


        return  tem;

    }



}
