package com.pps.service;

import com.pps.pojo.TbUser;
import com.pps.pojo.group.Result;

import java.security.NoSuchAlgorithmException;

/**
 * @Classname UserService
 * @Description 用户信息相关接口
 * @@Author Pupansheng
 * @Date 2019/8/16 16:56
 * @Vestion 1.0
 **/
public interface UserService {

    /*
     * @Author Pupansheng
     * @Description // 注册用户
     * @Date 10:20 2020/1/9
     * @Param
     * @return
     **/
    Result register(TbUser tbUser);
    /*
     * @Author Pupansheng
     * @Description // 更新用户信息
     * @Date 10:20 2020/1/9
     * @Param
     * @return
     **/
    Result update(TbUser tbUser);
    /*
     * @Author Pupansheng
     * @Description // 更新用户头像
     * @Date 10:21 2020/1/9
     * @Param
     * @return
     **/
    Result updateImage(TbUser tbUser);

    /*
     * @Author Pupansheng
     * @Description // 更新密码
     * @Date 10:21 2020/1/9
     * @Param
     * @return
     **/

    Result updatePassword(TbUser tbUser) throws NoSuchAlgorithmException;

    /*
     * @Author Pupansheng
     * @Description // 根据userpointID获得对应用户信息
     * @Date 10:21 2020/1/9
     * @Param
     * @return
     **/

    Result findUserById(String integer);
    
    /*
     * @Author Pupansheng
     * @Description // 主键获得基本信息
     * @Date 21:07 2020/1/11
     * @Param 
     * @return 
     **/

    Result findUserByPrimaryId(Integer id);


}
