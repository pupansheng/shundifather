package com.pps.config.compont;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname HuanXinHelper
 * @Description
 * @@Author Pupansheng
 * @Date 2020/1/27 18:07
 * @Vestion 1.0
 **/
@Component
public class HuanXinHelper {


    RestTemplate restTemplate=new RestTemplate();

    @Value("${sdkappid}")
    private String sdkappid;
    @Value("${key}")
    private String key;

    public String getKey() {
        return key;
    }

    @Value("${app_name}")
    String appName;
    @Value("${org_name}")
    String orgName;

    String preUrl="https://a1.easemob.com/"+orgName+"/"+appName+"/";
    //token有效截至日期
    static LocalDateTime date;
    //
    static  String token;

    /*
     * @Author Pupansheng
     * @Description // 初始化
     * @Date 17:47 2020/1/27
     * @Param
     * @return
     **/

    public  void init(){
        if(date!=null&&date.isAfter(LocalDateTime.now())){
            preUrl="https://a1.easemob.com/"+orgName+"/"+appName+"/";
            return;
        }
        preUrl="https://a1.easemob.com/"+orgName+"/"+appName+"/";
        String url=preUrl+"token";
        Map map=new HashMap();
        map.put("grant_type","client_credentials");
        map.put("client_id",sdkappid);
        map.put("client_secret",key);
        HttpHeaders headers = new HttpHeaders();
        /* 这个对象有add()方法，可往请求头存入信息 */
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        /* 解决中文乱码的关键 , 还有更深层次的问题 关系到 StringHttpMessageConverter，先占位，以后补全*/
        HttpEntity entity = new HttpEntity<Map>(map, headers);
        /* body是Http消息体例如json串 */
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, entity, String.class);
        String body=(String) stringResponseEntity.getBody();
        Map map1= JSON.parseObject(body,Map.class);
        String token2=(String) map1.get("access_token");
        HuanXinHelper.token=token2;
        Long expire=new Long((Integer)map1.get("expires_in"));
        String application=(String) map1.get("application");
        LocalDateTime localDateTime=LocalDateTime.now();
        LocalDateTime plus = localDateTime.plus(expire, ChronoUnit.SECONDS);
        HuanXinHelper.date=plus;
    }

    /**
     * 获取HttpHeaders
     *
     * @param contentType 客户端发送类型
     * @param accept      响应类型
     * @return HttpHeaders
     */
    private static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + HuanXinHelper.token);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return headers;
    }


    /*
     * @Author Pupansheng
     * @Description // 注册用户
     * @Date 12:06 2020/1/28
     * @Param
     * @return
     **/
    public   Boolean sendPostJson(String url2, Map body){
        init();
        String url=preUrl+url2;
        /* 注意：必须 http、https……开头，不然报错，浏览器地址栏不加 http 之类不出错是因为浏览器自动帮你补全了 */
        HttpHeaders headers = getHttpHeaders();
        /* 解决中文乱码的关键 , 还有更深层次的问题 关系到 StringHttpMessageConverter，先占位，以后补全*/
        HttpEntity entity = new HttpEntity<Map>(body, headers);
        /* body是Http消息体例如json串 */
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, entity, String.class);
        return  stringResponseEntity.getStatusCodeValue()==200;
    }

    /*
     * @Author Pupansheng
     * @Description // 推送信息给用户
     * @Date 17:47 2020/1/27
     * @Param
     * @return
     **/
    public  boolean  sendTextMessagetoUser(String [] to,String content){
        init();
        JSONObject body = new JSONObject();
        body.put("target_type", "users");
        JSONArray targetUserjson = new JSONArray();
        for(String s:to){
            targetUserjson.add(s);
        }
        body.put("target", targetUserjson);
        JSONObject msgJson = new JSONObject();
        msgJson.put("type", "txt");
        msgJson.put("msg", content);
        body.put("msg", msgJson);
        HttpEntity httpEntity = new HttpEntity(body, getHttpHeaders());
        ResponseEntity responseEntity = restTemplate.postForEntity(preUrl+ "messages", httpEntity, null);
        return responseEntity.getStatusCodeValue()==200;
    }





}
