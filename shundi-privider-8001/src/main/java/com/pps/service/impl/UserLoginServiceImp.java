package com.pps.service.impl;

import com.pps.MyLog;
import com.pps.mapper.TbUserMapper;
import com.pps.pojo.TbUser;
import com.pps.pojo.TbUserExample;
import com.pps.pojo.group.Result;
import com.pps.pojo.mongo.TemporaryStorage;
import com.pps.service.UserLoginService;
import com.pps.util.MongodbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;



/**
 * @Classname UserLoginServiceImp
 * @Description
 * @@Author Pupansheng
 * @Date 2019/10/9 16:42
 * @Vestion 1.0
 **/
@Transactional
@Service
public class UserLoginServiceImp implements UserLoginService {

    @Autowired
    TbUserMapper tbUserMapper;
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    MongodbUtil mongodbUtil;


    @Override
    public Result loginWithAccount(TbUser tbUser) throws NoSuchAlgorithmException {

        TbUserExample tbUserExample=new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();

        criteria.andUsernameEqualTo(tbUser.getUsername());


        String password = tbUser.getPassword();
        MessageDigest sha = MessageDigest.getInstance("MD5");
        sha.update(password.getBytes());
        String s = new BigInteger(sha.digest()).toString(32);
        criteria.andPasswordEqualTo(s);
        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);

        if(tbUsers==null||tbUsers.size()<=0){
            TbUserExample tbUserExample2=new TbUserExample();
            TbUserExample.Criteria criteria2 = tbUserExample2.createCriteria();


            criteria2.andPhoneEqualTo(tbUser.getUsername());
            criteria2.andPasswordEqualTo(s);
            List<TbUser> tbUsers2 = tbUserMapper.selectByExample(tbUserExample2);

            if(tbUsers2==null||tbUsers2.size()<=0)
                return  new Result(false,"登陆失败");
            else {
                return new Result(true,tbUsers2.get(0));
            }

        }

        return new Result(true,tbUsers.get(0));
    }

    @Override
    public Result loginWithPhone(String phone, String yanzhengma) {

        String yan="";
        String key=phone+"login";
        TemporaryStorage tem = mongodbUtil.getDataByKey(key);
        if(tem==null){
            return  new Result(false,"请发送验证码");
        } else{
            yan= (String) tem.getData();
            if(yan.equals("")||!yan.equals(yanzhengma)){
                return  new Result(false,"验证码错误");
            } else{
                Date date=new Date();
                Date saveDate = tem.getSaveDate();
                long i = date.getTime()-saveDate.getTime();
                MyLog.logger.info("验证码存在时间："+i);
                if(i>60*1000) {
                    return new Result(false, "验证码过期");
                }
            }
        }

        Query query=new Query();
        Criteria criteria2 = Criteria.where("key").is(key);
        query.addCriteria(criteria2);
        mongoTemplate.remove(query,"shundiStorage");



        MyLog.logger.info("短信验证码验证码："+yan);
        if(yanzhengma.equals(yan)){
            TbUserExample ex=new TbUserExample();
            TbUserExample.Criteria criteria = ex.createCriteria();
            criteria.andPhoneEqualTo(phone);
            List<TbUser> tbUsers = tbUserMapper.selectByExample(ex);
            if(tbUsers==null||tbUsers.size()<=0){
                return new Result(false,"用户不存在");
            }
            return  new Result(true,tbUsers.get(0));
        }else {
            return  new Result(false,"验证码过期或者错误");
        }
    }

    @Override
    public Result loginWithWeiXin(String openid) {

        TbUserExample ex=new TbUserExample();
        TbUserExample.Criteria criteria = ex.createCriteria();
        criteria.andOpenidEqualTo(openid);
        List<TbUser> tbUsers = tbUserMapper.selectByExample(ex);
        if(tbUsers==null||tbUsers.size()<=0){
            return new Result(false,"用户不存在");
        }
        return  new Result(true,tbUsers.get(0));
    }

    @Override
    public Result loginOut(String token) {


        MyLog.logger.info("退出登录：KEY="+token);
        Query query=new Query();
        Criteria criteria2 = Criteria.where("key").is(token);
        query.addCriteria(criteria2);
        TemporaryStorage tem = mongoTemplate.findAndRemove(query, TemporaryStorage.class, "shundiStorage");

        if(tem==null){
            return  new Result(false,"无此用户");
        } else
        {
            return  new Result(true,"退出成功");
        }

    }
}
