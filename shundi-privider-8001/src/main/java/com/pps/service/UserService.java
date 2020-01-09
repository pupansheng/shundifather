package com.pps.service;

import com.pps.pojo.TbUser;
import com.pps.pojo.group.Result;

/**
 * @Classname UserService
 * @Description
 * @@Author Pupansheng
 * @Date 2019/8/16 16:56
 * @Vestion 1.0
 **/
public interface UserService {

    public Result register(TbUser tbUser);
    public Result update(TbUser tbUser);
    public Result updateImage(TbUser tbUser);
    public Result updatePassword(TbUser tbUser);


    Result findUserById(String integer);
}
