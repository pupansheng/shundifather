package com.pps.service.impl;

import com.pps.config.compont.HuanXinHelper;
import com.pps.mapper.TbOrderMapper;
import com.pps.mapper.TbUserMapper;
import com.pps.pojo.TbOrder;
import com.pps.pojo.TbOrderExample;
import com.pps.pojo.TbUser;
import com.pps.pojo.TbUserExample;
import com.pps.pojo.exception.UnknowException;
import com.pps.pojo.group.Result;
import com.pps.service.UserPointService;
import com.pps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname UserServiceImp
 * @Description
 * @@Author Pupansheng
 * @Date 2019/8/16 17:02
 * @Vestion 1.0
 **/
@Transactional
@Service
public class UserServiceImp implements UserService {

    @Autowired
    TbUserMapper tbUserMapper;
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    UserPointService userPointService;
    @Autowired
    TbOrderMapper tbOrderMapper;
    @Autowired
    HuanXinHelper huanXinHelper;





    @Override
    public Result register(TbUser tbUser) {

        Result result=new Result();
        try{
            TbUserExample ex=new TbUserExample();
            TbUserExample.Criteria criteria = ex.createCriteria();
            criteria.andPhoneEqualTo(tbUser.getPhone());
            List<TbUser> tbUsers = tbUserMapper.selectByExample(ex);
            if(tbUsers.size()>0){
                return new Result(false,"手机号已被注册！");
            }
            TbUserExample ex2=new TbUserExample();
            TbUserExample.Criteria criteria2 = ex2.createCriteria();
            criteria2.andUsernameEqualTo(tbUser.getUsername());
            List<TbUser> tbUsers2 = tbUserMapper.selectByExample(ex2);
            if(tbUsers2.size()>0){
                return new Result(false,"用户名已被注册！");
            }

            tbUserMapper.insertSelective(tbUser);
            Map map=new HashMap();
            map.put("username",tbUser.getPhone());
            map.put("password",tbUser.getPhone());
            Boolean f=  huanXinHelper.sendPostJson("users", map);
            if(!f){
                throw new UnknowException("注册IM失败");
            }


            result.setStatus(true);
        }catch (Exception e){
           result.setStatus(false);
           result.setMessage("添加用户失败！");
        }
        return result;
    }
    @Override
    public Result update(TbUser tbUser) {
        Result result=new Result();
        try{
            tbUserMapper.updateByPrimaryKeySelective(tbUser);
            result.setStatus(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(false);
            result.setMessage("更新失败！");
        }
        return result;
    }

    @Override
    public Result updateImage(TbUser tbUser) {
        Result result=new Result();
        TbUser tbUser1=new TbUser();
        tbUser1.setHeadimage(tbUser.getHeadimage());
        tbUser1.setId(tbUser.getId());
        try{
            tbUserMapper.updateByPrimaryKeySelective(tbUser1);
            result.setStatus(true);
        }catch (Exception e){
            result.setStatus(false);
            result.setMessage("更新头像失败！");
        }
        return result;
    }

    @Override
    public Result updatePassword(TbUser tbUser) {

        String phone = tbUser.getPhone();
        TbUserExample tbUserExample=new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);
        if(tbUsers!=null&&tbUsers.size()>0){

            TbUser tbUser1 = tbUsers.get(0);
            tbUser1.setPassword(tbUser.getPassword());
            tbUserMapper.updateByPrimaryKeySelective(tbUser1);

            return new Result(true,"成功");
        }
        return  new Result(false,"无此用户");
    }

    @Override
    public Result findUserById(String integer) {

        TbOrderExample tbOrderExample=new TbOrderExample();
        TbOrderExample.Criteria criteria = tbOrderExample.createCriteria();
        criteria.andUserpointidEqualTo(integer);
        List<TbOrder> tbOrders = tbOrderMapper.selectByExample(tbOrderExample);
        if(tbOrders.size()<=0){
         throw new UnknowException("无此信息");
        }

        TbUser tbUser = tbUserMapper.selectByPrimaryKey(tbOrders.get(0).getUserid());
        if(tbUser!=null){
            tbUser.setIdcardimage1(null);
            tbUser.setIdcardimage2(null);
            tbUser.setPassword(null);
            tbUser.setOpenid(null);
            tbUser.setMoney(null);
            return new Result(true,tbUser);

        }else{
            return  new Result(false,"无此用户");
        }

    }

    @Override
    public Result findUserByPrimaryId(Integer id) {


        TbUser tbUser = tbUserMapper.selectByPrimaryKey(id);
        tbUser.setPassword(null);

        return new Result(true,tbUser);
    }
}
