package com.pps.controller;

import com.pps.MyLog;
import com.pps.pojo.group.Result;
import com.pps.pojo.mongo.UserPoint;
import com.pps.service.UserPointService;
import com.pps.util.IdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResults;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Classname UserPointController
 * @Description
 * @@Author Pupansheng
 * @Date 2019/10/9 9:14
 * @Vestion 1.0
 **/
@Api("用户定位模块")
@RestController
@RequestMapping("/user")
public class UserPointController {


    @Autowired
    private UserPointService userPointService;


    //保存乘客坐标地点
    @ApiOperation(value = "保存客户坐标信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "UserPoint", value = "用户坐标类", required = true, dataType = "UserPoint", paramType = "object"),


    })
    @RequestMapping(value = "/userPoint/save",method = RequestMethod.POST)
    public Result savePoint(@RequestBody UserPoint userPoint){

        MyLog.logger.info("乘客保存坐标信息："+userPoint);
        userPoint.setCreateTime(new Date());
       // userPoint.set_id(String.valueOf(new IdWorker().nextId()));
        return  userPointService.saveUserPoint(userPoint);

    }
    //乘客更新坐标地点
    @ApiOperation(value = "更新客户坐标信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "UserPoint", value = "用户坐标类", required = true, dataType = "UserPoint", paramType = "we48yix "),


    })

    @RequestMapping(value = "/userPoint/update",method = RequestMethod.POST)
    public Result updatePoint(@RequestBody UserPoint userPoint){

        MyLog.logger.info("乘客更新坐标信息："+userPoint);

        return  userPointService.saveUserPoint(userPoint);
    }
    //乘客删除坐标地点
    @ApiOperation(value = "删除客户坐标信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户坐标的主键", required = true, dataType = "String", paramType = "path"),


    })
    @RequestMapping(value = "/userPoint/delete/{id}",method = RequestMethod.POST)
    public Result deletePoint(@PathVariable("id") String id){

        MyLog.logger.info("乘客删除坐标信息："+id);

        return userPointService.deleteUserPoint(id) ;
    }
    //获得指定坐标周围乘客
    /*
     * @Author Pupansheng
     * @Description //
     * @Date 17:48 2019/8/20
     * @Param x  y  r=范围(单位m)
     * @return
     **/
    @ApiOperation(value = "获得附近的包裹", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "x", value = "lat", required = true, dataType = "Double", paramType = "path"),
            @ApiImplicitParam(name = "y", value = "long", required = true, dataType = "Double", paramType = "path"),
            @ApiImplicitParam(name = "r", value = "范围", required = true, dataType = "Double", paramType = "path"),

    })
    @RequestMapping(value = "/userPoint/getNearCargo/{x}/{y}/{r}",method = RequestMethod.POST)
    public GeoResults<UserPoint> getPoint(@PathVariable("x") Double x, @PathVariable("y") Double y, @PathVariable("r") Double r) {


        MyLog.logger.info("寻找附近包裹：("+x+","+y+")搜寻范围:="+r);

        return  userPointService.getNearUserPoint(x,y,0D,r/1000);

    }

    /*
     * @Author Pupansheng
     * @Description // 通过Id获得一个数据
     * @Date 10:53 2019/8/27
     * @Param
     * @return
     **/
    @ApiOperation(value = "获得客户坐标信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户坐标的主键", required = true, dataType = "String", paramType = "path"),


    })
    @RequestMapping(value = "/userPoint/findOne/{id}",method = RequestMethod.POST)
    public UserPoint findUserPointById(@PathVariable("id") String id){

        return    userPointService.getUserPoint(id);

    }

    /*
   * @Author Pupansheng
   * @Description // 通过user_Id获得多个个数据
   * @Date 10:53 2019/8/27
   * @Param
   * @return
   **/
    @ApiOperation(value = "根据userid获得客户信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "用户坐标的userid主键", required = true, dataType = "String", paramType = "path"),


    })
    @RequestMapping(value = "/userPoint/findMany/{id}",method = RequestMethod.POST)
    public List<UserPoint> findUserPointByUserId(@PathVariable("id") String id){

        return    userPointService.getUserPointsByUserId(id);

    }

    @RequestMapping(value = "/userPoint/findManyWithPage")
    public Result getUserPoint(int pageNum,int pageSize,int status,int userId){
        pageNum-=1;
        MyLog.logger.info("pageNum="+pageNum);
        return  userPointService.getUserPointByUserIdWithPage(pageNum,pageSize,status,userId);
    }

}
