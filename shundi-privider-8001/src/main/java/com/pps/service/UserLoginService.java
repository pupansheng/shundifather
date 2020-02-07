package com.pps.service;

import com.pps.pojo.TbUser;
import com.pps.pojo.group.Result;

import java.security.NoSuchAlgorithmException;

/*
 * @Author Pupansheng
 * @Description // 登录相关接口
 * @Date 10:23 2020/1/9
 * @Param 
 * @return 
 **/

public interface UserLoginService {

    /*
     * @Author Pupansheng
     * @Description // 账号登录
     * @Date 10:15 2020/1/9
     * @Param 
     * @return 
     **/
    
     Result loginWithAccount(TbUser tbUser) throws NoSuchAlgorithmException;
    /*
     * @Author Pupansheng
     * @Description // 短信登录
     * @Date 10:15 2020/1/9
     * @Param 
     * @return 
     **/
    
    Result loginWithPhone(String phone, String yanzhengma);
    /*
     * @Author Pupansheng
     * @Description // 微信登录 暂未实现
     * @Date 10:15 2020/1/9
     * @Param 
     * @return 
     **/
    
     Result loginWithWeiXin(String openid);
    
    /*
     * @Author Pupansheng
     * @Description // 退出登录
     * @Date 10:19 2020/1/9
     * @Param 
     * @return 
     **/
    
    Result loginOut(String token);


}
