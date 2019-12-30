package com.pps.service;

import com.pps.pojo.TbUser;
import com.pps.pojo.group.Result;

public interface UserLoginService {

    public Result loginWithAccount(TbUser tbUser);
    public Result loginWithPhone(String phone, String yanzhengma);
    public Result loginWithWeiXin(String openid);
    public Result loginOut(String token);


}
