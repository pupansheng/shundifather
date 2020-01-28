package com.pps.service.impl;

import com.pps.config.compont.HuanXinHelper;
import com.pps.mapper.TbUserMapper;
import com.pps.pojo.TbUser;
import com.pps.pojo.exception.UnknowException;
import com.pps.pojo.group.Result;
import com.pps.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.tools.tree.NegativeExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Classname PushServiceImpl
 * @Description
 * @@Author Pupansheng
 * @Date 2020/1/28 14:47
 * @Vestion 1.0
 **/
@Service
public class PushServiceImpl implements PushService {

    @Autowired
    TbUserMapper tbUserMapper;
    @Autowired
    HuanXinHelper huanXinHelper;




    @Override
    public Result sendAll(Map m) {

      String key=  (String) m.get("passKey");
      String key1 = huanXinHelper.getKey();
      if(key==null||key.equals("")||key!=key1){
          throw  new UnknowException("权限错误，无法调用接口");
      }
        List<TbUser> tbUsers = tbUserMapper.selectByExample(null);
         List<String> list=new ArrayList<>();
        for(TbUser tbUser:tbUsers){
            list.add(tbUser.getPhone());
        }

        String[] strings = list.toArray(new String[list.size()]);
        String content=(String)m.get("content");
        if(content!=null||content.equals("")){
            throw  new UnknowException("发送内容未填写");
        }
        boolean b = huanXinHelper.sendTextMessagetoUser(strings, content);

        if(b){
            return  new Result(true,"发送成功");
        }else{
            return  new Result(false,"发送失败");
        }
    }

    @Override
    public Result sendOne(Map m) {
        String key=  (String) m.get("passKey");
        String key1 = huanXinHelper.getKey();
        if(key==null||key.equals("")||key!=key1){
            throw  new UnknowException("权限错误，无法调用接口");
        }

        String to= (String) m.get("to");
        if(to!=null||to.equals("")){
            throw  new UnknowException("收信息人未填");
        }
        String content=(String)m.get("content");
        if(content!=null||content.equals("")){
            throw  new UnknowException("发送内容未填写");
        }
        boolean b = huanXinHelper.sendTextMessagetoUser(new String[]{to}, content);

        if(b){
            return  new Result(true,"发送成功");
        }else{
            return  new Result(false,"发送失败");
        }
    }
}
