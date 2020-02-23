package com.pps.controller;
import com.alibaba.fastjson.JSONObject;
import com.pps.MyLog;
import com.pps.pojo.group.Result;
import com.pps.service.WeiXinService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.util.Date;

/**
 * @author smileyan
 */
@RestController
@RequestMapping("/wechat")
public class WeChatLoginController {


    @Autowired
    WeiXinService weiXinService;

    @GetMapping("/getInfo")
    private Result login(String code,String datajson) {
        // 创建Httpclient对象

        MyLog.logger.info("微信登录："+new Date()+"||url=getInfo");
       return weiXinService.getInfo(code,datajson);
    }

}
