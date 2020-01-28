package com.pps.service;
import com.github.pagehelper.PageInfo;
import com.pps.pojo.TbOrder;
import com.pps.pojo.group.Result;
import java.util.Optional;

/*
 * @Author Pupansheng
 * @Description // 订单信息接口
 * @Date 10:23 2020/1/9
 * @Param 
 * @return 
 **/

public interface OrderService {

    /*
     * @Author Pupansheng
     * @Description // 增加订单
     * @Date 10:13 2020/1/9
     * @Param
     * @return
     **/

    TbOrder addOrder(TbOrder tbOrder);
    /*
     * @Author Pupansheng
     * @Description // 更新订单
     * @Date 10:13 2020/1/9
     * @Param
     * @return
     **/
    Optional<Boolean> updateOrder(TbOrder tbOrder);
    /*
     * @Author Pupansheng
     * @Description // 删除订单
     * @Date 10:13 2020/1/9
     * @Param
     * @return
     **/

    Boolean deleteOrder(TbOrder tbOrder);
    /*
     * @Author Pupansheng
     * @Description // 根据订单Id获得订单信息
     * @Date 10:13 2020/1/9
     * @Param
     * @return
     **/

    TbOrder findOrderById(Integer id);
    /*
     * @Author Pupansheng
     * @Description // 条件查询订单信息 带分页
     * @Date 10:14 2020/1/9
     * @Param
     * @return
     **/

    PageInfo findByCondition(TbOrder tbOrder,Integer pageNum,Integer pageSize);

    /*
     * @Author Pupansheng
     * @Description // 根据用户ID获得用户的各类订单
     * @Date 10:14 2020/1/9
     * @Param
     * @return
     **/
    Result getOrderNum(Integer userId);

    /*
     * @Author Pupansheng
     * @Description // 拒绝订单
     * @Date 10:23 2020/1/9
     * @Param
     * @return
     **/

    Result rejectOrder(TbOrder tbOrder);

    /*
     * @Author Pupansheng
     * @Description // 同意订单 返回取货码
     * @Date 10:23 2020/1/9
     * @Param
     * @return
     **/
    Result aggreeOrder(TbOrder tbOrder);

    /*
     * @Author Pupansheng
     * @Description // 根据主键查询
     * @Date 14:57 2020/1/9
     * @Param
     * @return
     **/
    Result queryOne(Integer id);


    /*
     * @Author Pupansheng
     * @Description // 已经将货物送到目的地
     * @Date 15:20 2020/1/9
     * @Param
     * @return
     **/

    Result daohuo(TbOrder tbOrder);




}
