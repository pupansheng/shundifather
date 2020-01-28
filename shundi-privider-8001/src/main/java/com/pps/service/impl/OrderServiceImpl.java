package com.pps.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mongodb.WriteResult;
import com.pps.config.compont.HuanXinHelper;
import com.pps.config.compont.MailConfig;
import com.pps.mapper.TbOrderMapper;
import com.pps.pojo.TbOrder;
import com.pps.pojo.TbOrderExample;
import com.pps.pojo.TbUser;
import com.pps.pojo.exception.UnknowException;
import com.pps.pojo.group.Result;
import com.pps.pojo.mongo.UserPoint;
import com.pps.pojo.status.OrderStatus;
import com.pps.pojo.status.PackageStatus;
import com.pps.service.OrderService;
import com.pps.service.UserPointService;
import com.pps.service.UserService;
import com.pps.util.MailSentTherd;
import org.bouncycastle.crypto.generators.KDF1BytesGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.*;

/**
 * @Classname OrderServiceImpl
 * @Description
 * @@Author Pupansheng
 * @Date 2019/12/15 18:05
 * @Vestion 1.0
 **/
@Transactional
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    TbOrderMapper tbOrderMapper;
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    UserPointService userPointService;
    @Autowired
    UserService userService;
    @Autowired
    MailConfig mailConfig;
    @Autowired
    HuanXinHelper huanXinHelper;


    @PostConstruct
    public  void  f(){
        System.out.println("邮件服务器列表如下：");
        mailConfig.getClient().forEach(p->{
            p.forEach((k,v)->{
                System.out.println(k+":"+v);
            });
        });
    }


    @Override
    public TbOrder addOrder(TbOrder tbOrder) {

        UserPoint userPoint = userPointService.getUserPoint(tbOrder.getUserpointid());
        int status=userPoint.getStatus();
        if(status!=PackageStatus.已提交.getCode()){
            throw new UnknowException("该货物此状态不可接单 请刷新页面 信息存在滞后");
        }


       tbOrder.setStatus(OrderStatus.已申请.getCode());

        tbOrder.setCreatetime(new Date());
        tbOrderMapper.insert(tbOrder);
        Optional.of(tbOrder.getId()).orElseThrow(UnknowException::new);

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(userPoint.get_id()));  //_id区分引号 "1"和1
        Update update = Update.update("status", PackageStatus.已申请.getCode());
        mongoTemplate.updateFirst(query,update,"userPoint");

        //接单者：
        TbUser tbUser= (TbUser) userService.findUserByPrimaryId(tbOrder.getUserid()).getData();
        //货主
        TbUser tbUser1= (TbUser) userService.findUserByPrimaryId(tbOrder.getOwnerid()).getData();

        //发送邮件提醒
        if(tbUser1.getBk1()!=null&&!tbUser1.getBk1().equals("")) {
            String content = "你的货物:" + userPoint.getGoods().getName() + "<p>在：" + new Date() + "时刻<hr>被用户：" + tbUser.getUsername() + "  接单</p><p></p>请前往我的包裹查看";
            String reciveUser = tbUser1.getBk1();
            String theme = "顺递APP提醒";
            String client = "";
            String password = "";
            List<Map<String, String>> client1 = mailConfig.getClient();
            int size = client1.size();
            if (System.currentTimeMillis() % 2 == 0) {

                client = client1.get(0).get("client");
                password = client1.get(0).get("password");

            } else if (System.currentTimeMillis() % 3 == 0) {

                client = client1.get(1).get("client");
                password = client1.get(1).get("password");

            } else if (System.currentTimeMillis() % 5 == 0) {

                client = client1.get(2).get("client");
                password = client1.get(2).get("password");

            } else {

                client = client1.get(size - 1).get("client");
                password = client1.get(size - 1).get("password");

            }
            new MailSentTherd(content, reciveUser, theme, client, password).run();

            //im提醒
            huanXinHelper.sendTextMessagetoUser(new String[]{tbUser1.getPhone()},content);
        }

        return  tbOrder;
    }

    @Override
    public Optional<Boolean> updateOrder(TbOrder tbOrder) {

        int i = tbOrderMapper.updateByPrimaryKeySelective(tbOrder);

        if(i >1) {
            throw  new UnknowException("更新订单失败");
        };

          return  Optional.of(true);
    }

    @Override
    public Boolean deleteOrder(TbOrder tbOrder) {

        int status = tbOrder.getStatus();
        if(status==OrderStatus.已申请.getCode()||status==OrderStatus.被拒绝.getCode()||status==OrderStatus.已同意.getCode()){

            if(status==OrderStatus.已申请.getCode()){

                Query query = new Query();
                query.addCriteria(Criteria.where("_id").is(tbOrder.getUserpointid()));  //_id区分引号 "1"和1
                Update update = Update.update("status", PackageStatus.已提交.getCode());
                WriteResult userPoint1 = mongoTemplate.updateFirst(query, update, "userPoint");

                UserPoint userPoint=userPointService.getUserPoint(tbOrder.getUserpointid());
                //接单者：
                TbUser tbUser= (TbUser) userService.findUserByPrimaryId(tbOrder.getUserid()).getData();
                //货主
                TbUser tbUser1= (TbUser) userService.findUserByPrimaryId(tbOrder.getOwnerid()).getData();
                //发送邮件提醒
                if(tbUser1.getBk1()!=null&&!tbUser1.getBk1().equals("")) {
                    String content = "你的货物:" + userPoint.getGoods().getName() + "<p>在：" + new Date() + "时刻</p><hr>被用户：" + tbUser.getUsername() + " 取消接单<p></p>请前往我的包裹查看";
                    String reciveUser = tbUser1.getBk1();
                    String theme = "顺递APP提醒";
                    String client = "";
                    String password = "";
                    List<Map<String, String>> client1 = mailConfig.getClient();
                    int size = client1.size();
                    if (System.currentTimeMillis() % 2 == 0) {

                        client = client1.get(0).get("client");
                        password = client1.get(0).get("password");

                    } else if (System.currentTimeMillis() % 3 == 0) {

                        client = client1.get(1).get("client");
                        password = client1.get(1).get("password");

                    } else if (System.currentTimeMillis() % 5 == 0) {

                        client = client1.get(2).get("client");
                        password = client1.get(2).get("password");

                    } else {

                        client = client1.get(size - 1).get("client");
                        password = client1.get(size - 1).get("password");

                    }
                    new MailSentTherd(content, reciveUser, theme, client, password).run();

                    //im提醒
                    huanXinHelper.sendTextMessagetoUser(new String[]{tbUser1.getPhone()},content);
                }

            }
            int c=  tbOrderMapper.deleteByPrimaryKey(tbOrder.getId());
            if(c>1){
                throw new UnknowException("删除失败");
            }
            return  Optional.of(c==1).get();

        }else{
            throw  new UnknowException("该状态下不可以改变其状态");
        }
    }

    @Override
    public TbOrder findOrderById(Integer id) {

     return     tbOrderMapper.selectByPrimaryKey(id);

    }

    @Override
    public PageInfo findByCondition(TbOrder tbOrder,Integer pageNum,Integer pageSize) {
         if(pageNum==null) {
             pageNum=1;
         }
         if(pageSize==null){
             pageSize=10;
         }
        TbOrderExample tbOrderExample=new TbOrderExample();
        TbOrderExample.Criteria criteria = tbOrderExample.createCriteria();

        if(tbOrder.getId()!=null){

            criteria.andIdEqualTo(tbOrder.getId());
        }
        if(tbOrder.getOwnerid()!=null){

            criteria.andOwneridEqualTo(tbOrder.getOwnerid());
        }
        if(tbOrder.getUserid()!=null){

            criteria.andUseridEqualTo(tbOrder.getUserid());
        }
        if(tbOrder.getUserpointid()!=null){

            criteria.andUserpointidEqualTo(tbOrder.getUserpointid());
        }
        if(tbOrder.getStatus()!=null){
            criteria.andStatusEqualTo(tbOrder.getStatus());
        }
        PageHelper.startPage(pageNum,pageSize);
        List<TbOrder> tbOrders = tbOrderMapper.selectByExample(tbOrderExample);
        PageInfo pageInfo = new PageInfo<>(tbOrders);

        return pageInfo;
    }

    @Override
    public Result getOrderNum(Integer userId) {

        HashMap hashMap=new HashMap();
        OrderStatus[] values = OrderStatus.values();
        Arrays.stream(values).forEach(p->{

            Integer code = p.getCode();
            TbOrderExample tbOrderExample=new TbOrderExample();
            TbOrderExample.Criteria criteria = tbOrderExample.createCriteria();
            criteria.andStatusEqualTo(code);
            criteria.andUseridEqualTo(userId);
            int count = tbOrderMapper.countByExample(tbOrderExample);
            hashMap.put(code+"",count);
        });
        return  new Result(true,hashMap);
    }

    @Override
    public Result rejectOrder(TbOrder tbOrder) {

        String userpointid = tbOrder.getUserpointid();
        UserPoint userPoint = userPointService.getUserPoint(userpointid);
        int status=userPoint.getStatus();
        if(status!=PackageStatus.待回复.getCode()){
            throw new UnknowException("此订单此状态不可进行此操作 请刷新页面");
        }

        userPointService.updateStatus(userPoint, PackageStatus.被拒绝.getCode());
        Boolean aBoolean = deleteOrder(tbOrder);

        //接单者：
        TbUser tbUser= (TbUser) userService.findUserByPrimaryId(tbOrder.getUserid()).getData();
        //货主
        TbUser tbUser1= (TbUser) userService.findUserByPrimaryId(tbOrder.getOwnerid()).getData();
        //发送邮件提醒
        if(tbUser1.getBk1()!=null&&!tbUser1.getBk1().equals("")) {
            String content = "你的货物:" + userPoint.getGoods().getName() + "<p>在：" + new Date() + "时刻</p><hr>被用户：" + tbUser.getUsername() + " 拒绝接单<p></p>请前往我的包裹查看";
            String reciveUser = tbUser1.getBk1();
            String theme = "顺递APP提醒";
            String client = "";
            String password = "";
            List<Map<String, String>> client1 = mailConfig.getClient();
            int size = client1.size();
            if (System.currentTimeMillis() % 2 == 0) {

                client = client1.get(0).get("client");
                password = client1.get(0).get("password");

            } else if (System.currentTimeMillis() % 3 == 0) {

                client = client1.get(1).get("client");
                password = client1.get(1).get("password");

            } else if (System.currentTimeMillis() % 5 == 0) {

                client = client1.get(2).get("client");
                password = client1.get(2).get("password");

            } else {

                client = client1.get(size - 1).get("client");
                password = client1.get(size - 1).get("password");

            }
            new MailSentTherd(content, reciveUser, theme, client, password).run();

            //im提醒
            huanXinHelper.sendTextMessagetoUser(new String[]{tbUser1.getPhone()},content);

    }


        return  new Result(aBoolean,aBoolean?null:"出错");

    }

    @Override
    public Result aggreeOrder(TbOrder tbOrder) {

        String userpointid = tbOrder.getUserpointid();
        UserPoint userPoint = userPointService.getUserPoint(userpointid);
        int status=userPoint.getStatus();
        if(status!=PackageStatus.待回复.getCode()){
            throw new UnknowException("此订单此状态不可进行此操作 请刷新页面");
        }
        //得到取货码
        String substring = UUID.randomUUID().toString().substring(0, 5);
        TbOrder tbOrder1=new TbOrder();
        tbOrder1.setId(tbOrder.getId());
        tbOrder1.setStatus(OrderStatus.进行中.getCode());
        tbOrder1.setBk1(substring);//bk1 取货码
        //交易成立时间 双方都同意 才算成立

        tbOrder1.setEstablishedtime(new Date());
        Optional<Boolean> aBoolean = updateOrder(tbOrder1);
        //更新寄件信息
        userPointService.updateStatus(userPoint,PackageStatus.进行中.getCode());

        //接单者：
        TbUser tbUser= (TbUser) userService.findUserByPrimaryId(tbOrder.getUserid()).getData();
        //货主
        TbUser tbUser1= (TbUser) userService.findUserByPrimaryId(tbOrder.getOwnerid()).getData();
        //发送邮件提醒
        if(tbUser1.getBk1()!=null&&!tbUser1.getBk1().equals("")) {
            String content = "您的货物:" + userPoint.getGoods().getName() + "在：" + new Date() + "时刻<br><hr>被用户：" + tbUser.getUsername() + " 确认接单<p></p>请前往我的包裹查看取货码，等待上门";
            String reciveUser = tbUser1.getBk1();
            String theme = "顺递APP提醒";
            String client = "";
            String password = "";
            List<Map<String, String>> client1 = mailConfig.getClient();
            int size = client1.size();
            if (System.currentTimeMillis() % 2 == 0) {

                client = client1.get(0).get("client");
                password = client1.get(0).get("password");

            } else if (System.currentTimeMillis() % 3 == 0) {

                client = client1.get(1).get("client");
                password = client1.get(1).get("password");

            } else if (System.currentTimeMillis() % 5 == 0) {

                client = client1.get(2).get("client");
                password = client1.get(2).get("password");

            } else {

                client = client1.get(size - 1).get("client");
                password = client1.get(size - 1).get("password");

            }
            new MailSentTherd(content, reciveUser, theme, client, password).run();
            //im提醒
            huanXinHelper.sendTextMessagetoUser(new String[]{tbUser1.getPhone()},content);
        }





        return new Result(true,"",substring);
    }

    @Override
    public Result queryOne(Integer id) {

        return new Result(true,tbOrderMapper.selectByPrimaryKey(id));
    }

    @Override
    public Result daohuo(TbOrder tbOrder) {

        TbOrder tbOrder1=new TbOrder();
        tbOrder1.setId(tbOrder.getId());
        tbOrder1.setStatus(OrderStatus.待支付.getCode());
        tbOrder1.setArrivaltime(new Date());
        int i = tbOrderMapper.updateByPrimaryKeySelective(tbOrder1);
        if(i!=1){
            throw new UnknowException("确认失败！");
        }
        UserPoint userPoint=userPointService.getUserPoint(tbOrder.getUserpointid());
        //接单者：
        TbUser tbUser= (TbUser) userService.findUserByPrimaryId(tbOrder.getUserid()).getData();
        //货主
        TbUser tbUser1= (TbUser) userService.findUserByPrimaryId(tbOrder.getOwnerid()).getData();
        //发送邮件提醒
        if(tbUser1.getBk1()!=null&&!tbUser1.getBk1().equals("")) {
            String content = "你的货物:" + userPoint.getGoods().getName() + "在：" + new Date() + "时刻<br><hr>被用户：" + tbUser.getUsername() + " 确认到货<p></p>请前往我的包裹查看";
            String reciveUser = tbUser1.getBk1();
            String theme = "顺递APP提醒";
            String client = "";
            String password = "";
            List<Map<String, String>> client1 = mailConfig.getClient();
            int size = client1.size();
            if (System.currentTimeMillis() % 2 == 0) {

                client = client1.get(0).get("client");
                password = client1.get(0).get("password");

            } else if (System.currentTimeMillis() % 3 == 0) {

                client = client1.get(1).get("client");
                password = client1.get(1).get("password");

            } else if (System.currentTimeMillis() % 5 == 0) {

                client = client1.get(2).get("client");
                password = client1.get(2).get("password");

            } else {

                client = client1.get(size - 1).get("client");
                password = client1.get(size - 1).get("password");

            }
            new MailSentTherd(content, reciveUser, theme, client, password).run();

            //im提醒
            huanXinHelper.sendTextMessagetoUser(new String[]{tbUser1.getPhone()},content);
        }


      /*  UserPoint userPoint=new UserPoint();
        userPoint.set_id(tbOrder.getUserpointid());
        userPointService.setStatus(userPoint,PackageStatus.getCode());*/
        return new Result(true,null);
    }
}
