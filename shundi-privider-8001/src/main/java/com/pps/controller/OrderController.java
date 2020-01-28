package com.pps.controller;

import com.github.pagehelper.PageInfo;
import com.pps.pojo.TbOrder;
import com.pps.pojo.TbUser;
import com.pps.pojo.group.Result;
import com.pps.service.OrderService;
import com.pps.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @Classname OrderController
 * @Description
 * @@Author Pupansheng
 * @Date 2019/12/15 18:02
 * @Vestion 1.0
 **/
@Api("订单模块")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @ApiOperation(value = "添加一个新的订单", notes = "")
    @PostMapping("/add")
    public Result add(@RequestBody TbOrder tbOrder){

        TbOrder tbOrder1 = orderService.addOrder(tbOrder);
        if(tbOrder1.getId()!=null){
            return  new Result(true,tbOrder1);
        }else {
            return  new Result(false,"失败");
        }

    }

    @ApiOperation(value = "条件查询订单信息", notes = "")
    @PostMapping("/query/condition")
    public  Result query(@RequestBody TbOrder tbOrder){

        PageInfo byCondition = orderService.findByCondition(tbOrder, tbOrder.getPageNum(), tbOrder.getPageSize());
        return  new Result(true,byCondition);

    }


    @ApiOperation(value = "获得各类订单的数量", notes = "")
    @GetMapping("/query/getOrderNum")
    public  Result getNUm(Integer userId){

       return  orderService.getOrderNum(userId);

    }

    @ApiOperation(value = "更新订单", notes = "")
    @PostMapping("/update")
    public  Result updateOrder(@RequestBody TbOrder tbOrder){

        Optional<Boolean> aBoolean = orderService.updateOrder(tbOrder);

        return  new Result(aBoolean.get(),aBoolean.get()?"更新成功":"更新失败");


    }


    @ApiOperation(value = "删除订单记录", notes = "")
    @PostMapping("/delete")
    public  Result deleteOrder(@RequestBody TbOrder tbOrder){

        Boolean aBoolean = orderService.deleteOrder(tbOrder);
        return  new Result(aBoolean,aBoolean?"删除成功":"删除失败");

    }


    @ApiOperation(value = "接受用户的价格 确认接单 返回取货码", notes = "")
    @PostMapping("/confirm")
    public  Result confirmOrder(@RequestBody TbOrder tbOrder){


        return  orderService.aggreeOrder(tbOrder);

    }
    @ApiOperation(value = "不接受用户的价格 拒绝接单 ", notes = "")
    @PostMapping("/reject")
    public  Result rejectOrder(@RequestBody TbOrder tbOrder){

        return  orderService.rejectOrder(tbOrder);


    }
    @ApiOperation(value = "已经将寄件送到货 ", notes = "")
    @PostMapping("/daohuo")
    public  Result daohuo(@RequestBody TbOrder tbOrder){

        return  orderService.daohuo(tbOrder);


    }

    @ApiOperation(value = "根据订单获得货主信息 ", notes = "")
    @GetMapping("/getBasicInfo/{id}")
    public  Result  getINfo(@PathVariable("id") Integer id){

        Result userByPrimaryId = userService.findUserByPrimaryId(id);
        TbUser tbUser=(TbUser) userByPrimaryId.getData();
        tbUser.setPassword("");
        tbUser.setOpenid("");

        return  new Result(true,tbUser);

    }



}
