package com.pps.controller;

import com.pps.pojo.TbOrder;
import com.pps.pojo.group.Result;
import com.pps.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OrderController
 * @Description
 * @@Author Pupansheng
 * @Date 2019/12/15 18:02
 * @Vestion 1.0
 **/
@Api("客户端登录模块")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/add")
    public Result add(@RequestBody TbOrder tbOrder){

        TbOrder tbOrder1 = orderService.addOrder(tbOrder);
        if(tbOrder1.getId()!=null){
            return  new Result(true,tbOrder1);
        }else {
            return  new Result(false,"失败");
        }


    }


}
