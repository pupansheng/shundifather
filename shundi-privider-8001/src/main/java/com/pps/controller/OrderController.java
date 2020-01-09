package com.pps.controller;

import com.github.pagehelper.PageInfo;
import com.pps.pojo.TbOrder;
import com.pps.pojo.group.Result;
import com.pps.service.OrderService;
import io.swagger.annotations.Api;
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

    @PostMapping("/add")
    public Result add(@RequestBody TbOrder tbOrder){

        TbOrder tbOrder1 = orderService.addOrder(tbOrder);
        if(tbOrder1.getId()!=null){
            return  new Result(true,tbOrder1);
        }else {
            return  new Result(false,"失败");
        }

    }
    @PostMapping("/query/condition")
    public  Result query(@RequestBody TbOrder tbOrder){

        PageInfo byCondition = orderService.findByCondition(tbOrder, tbOrder.getPageNum(), tbOrder.getPageSize());
        return  new Result(true,byCondition);

    }

    @GetMapping("/query/getOrderNum")
    public  Result getNUm(Integer userId){

       return  orderService.getOrderNum(userId);

    }

    @PostMapping("/update")
    public  Result updateOrder(@RequestBody TbOrder tbOrder){

        Optional<Boolean> aBoolean = orderService.updateOrder(tbOrder);

        return  new Result(aBoolean.get(),aBoolean.get()?"更新成功":"更新失败");


    }
    @PostMapping("/delete")
    public  Result deleteOrder(@RequestBody TbOrder tbOrder){
        Boolean aBoolean = orderService.deleteOrder(tbOrder);
        return  new Result(aBoolean,aBoolean?"删除成功":"删除失败");
    }
}
