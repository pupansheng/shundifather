package com.pps.config.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.pps.MyLog;
import com.pps.config.compont.JWT;
import com.pps.pojo.exception.NoAuthorizationException;
import com.pps.pojo.mongo.TemporaryStorage;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Slf4j
@Component
public class MyInterceptor implements HandlerInterceptor {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private JWT jwt;

    //在请求处理之前进行调用（Controller方法调用之前
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {


        // 需要验证
        String token = getToken(httpServletRequest);

        if (StringUtils.isBlank(token)) {
            MyLog.logger.info("未登陆");
            throw new NoAuthorizationException();
        }
        // 获取签名信息
        Claims claims = jwt.getClaimByToken(token);
        MyLog.logger.info("TOKEN: " + claims);
        // 判断签名是否存在或过期
        boolean b = claims==null || claims.isEmpty() || jwt.isTokenExpired(claims.getExpiration());
        if (b) {
            MyLog.logger.info("登陆过期");
            throw new NoAuthorizationException();
        }




        return  true;

      /*  Query query=new Query();
        Criteria criteria = Criteria.where("key").is(token);
        query.addCriteria(criteria);
        TemporaryStorage tem = mongoTemplate.findOne(query, TemporaryStorage.class, "shundiStorage");
        if(tem==null){

            //输出响应流
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", "false");
            jsonObject.put("code", "1000");
            jsonObject.put("message", "未登录,权限错误");
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json; charset=utf-8");
            httpServletResponse.getOutputStream().write(jsonObject.toJSONString().getBytes("UTF-8"));
            return false;


        }else{

            Date date=new Date();
            Date saveDate = tem.getSaveDate();
            long i = date.getTime()-saveDate.getTime();
            MyLog.logger.info("token存在时间："+i/1000+"s");
            if(i>60*1000*7) {

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("status", "false");
                jsonObject.put("code", "1000");
                jsonObject.put("message", "token已过期");
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setContentType("application/json; charset=utf-8");
                httpServletResponse.getOutputStream().write(jsonObject.toJSONString().getBytes("UTF-8"));
                return false;
            }else{
                return  true;
            }

        }*/





    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
    /**
     * 获取请求Token
     */
    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(jwt.getHeader());
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(jwt.getHeader());
        }
        return token;
    }
}