package com.pps.config.exception;

import com.pps.pojo.exception.NoAuthorizationException;
import com.pps.pojo.exception.UnknowException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname MyExceptionHandler
 * @Description
 * @@Author Pupansheng
 * @Date 2019/12/21 15:17
 * @Vestion 1.0
 **/
@ControllerAdvice
public class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler(NoAuthorizationException.class)
    public Map<String,Object> handleException(NoAuthorizationException e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","1000");
        map.put("message","登陆过期");
        return map;
    }
    @ResponseBody
    @ExceptionHandler(UnknowException.class)
    public Map<String,Object> handleException(UnknowException e){
        e.printStackTrace();
        Map<String,Object> map = new HashMap<>();
        map.put("code","900");
        map.put("message","业务错误："+e.getMessage());
        return map;
    }
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String,Object> handleException2(Exception e){
        e.printStackTrace();
        Map<String,Object> map = new HashMap<>();
        map.put("code","900");
        map.put("message","未知错误："+e.getMessage());
        return map;
    }


}
