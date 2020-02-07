package com.pps.controller;

import com.pps.MyLog;
import com.pps.pojo.TbUser;
import com.pps.pojo.group.Result;
import com.pps.pojo.mongo.TemporaryStorage;
import com.pps.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @Classname UserManagerController
 * @Description
 * @@Author Pupansheng
 * @Date 2019/10/9 9:13
 * @Vestion 1.0
 **/
@Api("客户端用户管理模块")
@RestController
@RequestMapping("/user")
public class UserManagerController {


    @Autowired
    private UserService userService;

    @Autowired
    private MongoTemplate mongoTemplate;


    //用户注册
    @ApiOperation(value = "用户注册", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tbuser", value = "注册的用户类", required = true, dataType = "TbUser", paramType = "object"),
            @ApiImplicitParam(name = "yanzhengma", value = "验证码", required = true, dataType = "String", paramType = "path")

    })
    @RequestMapping(value = "/register/{yanzhengma}",method = RequestMethod.POST)
    public Result register(@RequestBody TbUser tbUser, @PathVariable String yanzhengma){

        //String yanzhengma2=(String)request.getSession().getAttribute("registeryanzhengma");

        MyLog.logger.info("-----------------------"+tbUser);
        String yanzhengma2="";
        String key=tbUser.getPhone()+"register";
        MyLog.logger.info("KEY="+key);
        Query query=new Query();
        Criteria criteria = Criteria.where("key").is(key);
        query.addCriteria(criteria);
        TemporaryStorage tem = mongoTemplate.findOne(query, TemporaryStorage.class, "shundiStorage");
        if(tem==null){
            return  new Result(false,"请发送验证码");
        } else{
            yanzhengma2= (String) tem.getData();
            if(yanzhengma2==null||yanzhengma2.equals("")||!yanzhengma2.equals(yanzhengma)){
                return  new Result(false,"验证码错误");
            } else {
                Date date=new Date();
                Date saveDate = tem.getSaveDate();
                long i = date.getTime()-saveDate.getTime();
                MyLog.logger.info("验证码存在时间："+i/1000+"s");
                if(i>60*1000) {
                    return new Result(false, "验证码过期");
                }
            }
        }

        mongoTemplate.remove(query,"shundiStorage");
        return  userService.register(tbUser);
    }


    /*
     * @Author Pupansheng
     * @Description // phone 为送验证码的手机号
     * @Date 16:19 2019/10/9
     * @Param
     * @return
     **/
    @ApiOperation(value = "用户更新信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tbuser", value = "用户类", required = true, dataType = "TbUser", paramType = "path"),
            @ApiImplicitParam(name = "phone", value = "电话", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "yanzhengma", value = "验证码", required = true, dataType = "String", paramType = "path")

    })
    @RequestMapping(value ="/update/{phone}/{yanzhengma}",method = RequestMethod.POST)
    public Result updateUser2(@RequestBody TbUser tbUser, @PathVariable String yanzhengma, @PathVariable String phone){
        String yan="";
        String key=phone+"update";
        MyLog.logger.info("KEY="+key);
        Query query=new Query();
        Criteria criteria = Criteria.where("key").is(key);
        query.addCriteria(criteria);
        TemporaryStorage tem = mongoTemplate.findOne(query, TemporaryStorage.class, "shundiStorage");
        if(tem==null){
            return  new Result(false,"请发送验证码");
        } else{
            yan= (String) tem.getData();
            if(yan==null||yan.equals("")||!yan.equals(yanzhengma)){
                return  new Result(false,"验证码错误");
            } else {
                Date date=new Date();
                Date saveDate = tem.getSaveDate();
                long i = date.getTime()-saveDate.getTime();
                MyLog.logger.info("验证码存在时间："+i);
                if(i>60*1000) {
                    return new Result(false, "验证码过期");
                }
            }
        }

        mongoTemplate.remove(query,"shundiStorage");
        MyLog.logger.info("更新用户信息："+tbUser);
        return  userService.update(tbUser);
    }

    @ApiOperation(value = "用户更新头像", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tbuser", value = "用户类", required = true, dataType = "TbUser", paramType = "path")
    })
    @RequestMapping("/update/headimage")
    public Result updateHeadImage(@RequestBody TbUser tbUser){

        Result result = userService.updateImage(tbUser);
        return  result;
    }

    @ApiOperation(value = "用户改变密码", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tbuser", value = "用户类", required = true, dataType = "TbUser", paramType = "path"),
            @ApiImplicitParam(name = "phone", value = "电话", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "yanzhengma", value = "验证码", required = true, dataType = "String", paramType = "path")

    })
    @RequestMapping(value ="/update/resetpassword/{phone}/{yanzhengma}",method = RequestMethod.POST)
    public Result updatePassword(@RequestBody TbUser tbUser, @PathVariable("yanzhengma") String yanzhengma, @PathVariable("phone") String phone) throws NoSuchAlgorithmException {
        String yan="";
        String key=phone+"update";
        MyLog.logger.info("KEY="+key);
        Query query=new Query();
        Criteria criteria = Criteria.where("key").is(key);
        query.addCriteria(criteria);
        TemporaryStorage tem = mongoTemplate.findOne(query, TemporaryStorage.class, "shundiStorage");
        if(tem==null){
            return  new Result(false,"请发送验证码");
        } else{
            yan= (String) tem.getData();
            if(yan==null||yan.equals("")||!yan.equals(yanzhengma)){
                return  new Result(false,"验证码错误");
            } else {
                Date date = new Date();
                Date saveDate = tem.getSaveDate();
                long i = date.getTime() - saveDate.getTime();
                MyLog.logger.info("验证码存在时间：" + i);
                if (i > 60 * 1000) {
                    return new Result(false, "验证码过期");
                }
            }
        }

        mongoTemplate.remove(query,"shundiStorage");
        MyLog.logger.info("更新用户密码："+tbUser);
        Result result = userService.updatePassword(tbUser);
        return  result;
    }
    @ApiOperation("根据主键获得用户基本信息")
    @GetMapping("/getBasciInfo/{id}")
    public Result getBASIC(@PathVariable("id") Integer id){

        return  userService.findUserByPrimaryId(id);
    }

}
