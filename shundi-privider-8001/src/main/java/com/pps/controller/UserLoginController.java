package com.pps.controller;

import com.alibaba.fastjson.JSON;
import com.pps.MyLog;
import com.pps.config.compont.JWT;
import com.pps.pojo.TbUser;
import com.pps.pojo.exception.NoAuthorizationException;
import com.pps.pojo.group.Result;
import com.pps.pojo.mongo.TemporaryStorage;
import com.pps.service.UserLoginService;
import com.pps.service.UserService;
import com.pps.util.UUIDUtil;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Enumeration;

/**
 * @Classname UserLoginController
 * @Description
 * @@Author Pupansheng
 * @Date 2019/10/9 9:10
 * @Vestion 1.0
 **/
@Api("客户端登录模块")
@RestController
@RequestMapping("/user")
public class UserLoginController {


    @Autowired
    private UserLoginService userLoginService;


    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    UserService userService;
    @Autowired
    private JWT jwt;



    /*
     * @Author Pupansheng
     * @Description // 账号登录
     * @Date 10:23 2019/10/10
     * @Param
     * @return
     **/
    @ApiOperation(value = "账号密码登录", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tbUser", value = "用户账号", required = true, dataType = "TbUser", paramType = "object"),

    })
    @RequestMapping(value = "/login/account",method = RequestMethod.POST)
    public Result loginWithAccount(@RequestBody TbUser tbUser,HttpServletRequest httpServletRequest) throws Exception{

        MyLog.logger.info("账号登录信息：" + tbUser);
        Result result = userLoginService.loginWithAccount(tbUser);
        if (result.isStatus()) {

            Integer id = ((TbUser) result.getData()).getId();
            String token = jwt.generateToken(id);
            MyLog.logger.info("账号登录成功  产生token:"+token);
            result.setMessage(token);


            //登陆成功 产生jwt token
          /*  Enumeration<String> attributeNames = httpServletRequest.getAttributeNames();
            String token = UUIDUtil.getUUID();
            TemporaryStorage temporaryStorage = new TemporaryStorage();
            temporaryStorage.setKey(token);
            temporaryStorage.setData(JSON.toJSONString(result.getData()));
            temporaryStorage.setSaveDate(new Date());
            mongoTemplate.save(temporaryStorage, "shundiStorage");
            MyLog.logger.info("产生token=" + token);
            result.setMessage(token);*/

        }

        return result;
    }

    /*
     * @Author Pupansheng
     * @Description // 手机短信登录
     * @Date 10:24 2019/10/10
     * @Param
     * @return
     **/
    @ApiOperation(value = "手机短信登录", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "电话号码", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "yanzhengma", value = "验证码", required = true, dataType = "String", paramType = "path")

    })
    @RequestMapping(value = "/login/phone/{phone}/{yanzhengma}")
    public Result loginWithphone(@PathVariable String phone, @PathVariable String yanzhengma, HttpServletRequest request, HttpServletResponse response) {

        MyLog.logger.info("客户手机短信登录信息：电话号码=" + phone + "验证码=" + yanzhengma);
        Result result = userLoginService.loginWithPhone(phone, yanzhengma);
        if (result.isStatus()) {

            Integer id = ((TbUser) result.getData()).getId();
            String token = jwt.generateToken(id);
            MyLog.logger.info("手机登录成功  产生token:"+token);
            result.setMessage(token);
          /*  String token = UUIDUtil.getUUID();
            TemporaryStorage temporaryStorage = new TemporaryStorage();
            temporaryStorage.setKey(token);
            temporaryStorage.setData(JSON.toJSONString(result.getData()));
            temporaryStorage.setSaveDate(new Date());
            mongoTemplate.save(temporaryStorage, "shundiStorage");
            result.setMessage(token);*/

        }
        return result;
    }


    /*
     * @Author Pupansheng
     * @Description // 微信登录
     * @Date 10:24 2019/10/10
     * @Param
     * @return
     **/
    @ApiOperation(value = "微信登录", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "openid", value = "客户端微信登录得到的唯一标识", required = true, dataType = "String", paramType = "path"),


    })
    @RequestMapping(value = "/login/weixin",method = RequestMethod.GET)
    public Result LoginWithWeiXin(String openid) {

        Result result = userLoginService.loginWithWeiXin(openid);

        if (result.isStatus()) {

            Integer id = ((TbUser) result.getData()).getId();
            String token = jwt.generateToken(id);
            MyLog.logger.info("微信登录成功  产生token:"+token);
            result.setMessage(token);


           /* String token = UUIDUtil.getUUID();
            TemporaryStorage temporaryStorage = new TemporaryStorage();
            temporaryStorage.setKey(token);
            temporaryStorage.setData(JSON.toJSONString(result.getData()));
            temporaryStorage.setSaveDate(new Date());
            mongoTemplate.save(temporaryStorage, "shundiStorage");
            result.setMessage(token);*/

        }
        return result;

    }

    /*
     * @Author Pupansheng
     * @Description // 退出登录
     * @Date 10:26 2019/10/10
     * @Param
     * @return
     **/
    @ApiOperation(value = "退出登录", notes = "已废弃")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "客户端登录获得的票据", required = true, dataType = "String", paramType = "path"),


    })
    @RequestMapping(value = "/loginOut/{token}")
    public Result loginOut(@PathVariable("token") String token) {


        return userLoginService.loginOut(token);


    }

    /*
     * @Author Pupansheng
     * @Description // 根据token登录
     * @Date 10:23 2019/10/10
     * @Param
     * @return
     **/
    @ApiOperation(value = "票据登录", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "客户端第一次登录成功后服务器返回的票据15天内可以用它登录", required = true, dataType = "String", paramType = "path"),


    })
    @RequestMapping(value = "/login/getUserInfo")
    public Result checkIsLogin(HttpServletRequest httpServletRequest) {

        MyLog.logger.info("微信登录："+new Date()+"||url=/login/getUserInfo");
        String header = httpServletRequest.getHeader("shundi-token");
        Claims claims = jwt.getClaimByToken(header);
        MyLog.logger.info("自动登录TOKEN: " + claims);
        // 判断签名是否存在或过期
        boolean b = claims==null || claims.isEmpty() || jwt.isTokenExpired(claims.getExpiration());
        if (b) {
            throw new NoAuthorizationException();
        }

        String subject = claims.getSubject();
        Result result  = userService.findUserByPrimaryId(Integer.parseInt(subject));
        return result;

      /*  Query query = new Query();
        Criteria criteria = Criteria.where("key").is(aceess_token);
        query.addCriteria(criteria);
        TemporaryStorage tem = mongoTemplate.findOne(query, TemporaryStorage.class, "shundiStorage");
        MyLog.logger.info("票据用户："+tem);
        if (tem == null) {
            return new Result(false, "登陆失败");
        } else {

            Date saveDate = tem.getSaveDate();
            Date date = new Date();
            long l = date.getTime() - saveDate.getTime();
            if (l > 7 * 24 * 3600 * 1000) {

                mongoTemplate.remove(query,"shundiStorage");
                return new Result(false, "登录过期请重新登录");
            } else {

                Result result = new Result();
                TbUser tbUser = JSON.parseObject((String) tem.getData(), TbUser.class);

                result.setData(userService.findUserByPrimaryId(tbUser.getId()).getData());
                result.setStatus(true);
                return result;
            }
        }*/

    }

}
