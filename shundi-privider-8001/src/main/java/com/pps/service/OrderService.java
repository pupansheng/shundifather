package com.pps.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.pps.pojo.TbOrder;
import com.pps.pojo.group.Result;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    TbOrder addOrder(TbOrder tbOrder);
    Optional<Boolean> updateOrder(TbOrder tbOrder);
    Boolean deleteOrder(TbOrder tbOrder);
    TbOrder findOrderById(Integer id);
    PageInfo findByCondition(TbOrder tbOrder,Integer pageNum,Integer pageSize);

    Result getOrderNum(Integer userId);



}
