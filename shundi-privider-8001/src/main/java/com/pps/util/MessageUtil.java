package com.pps.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Classname MessageUtil
 * @Description
 * @@Author Pupansheng
 * @Date 2019/7/16 11:45
 * @Vestion 1.0
 **/
@Component
public class MessageUtil {



    @Value("${keyId}")
    String keyID;
    @Value("${secrect}")
    String secrect;






    public  boolean sendMessage(String typeTemplate,String code,String phoneNumber){

        boolean re=true;
       DefaultProfile profile = DefaultProfile.getProfile("自贡", keyID, secrect);
      //  DefaultProfile profile = DefaultProfile.getProfile("自贡", "LTAIETmbl8VB0OYY", "MNgh412fbGSaBhWuLxlNdCB4GJivOu");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "自贡");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", "速安");
        request.putQueryParameter("TemplateCode", typeTemplate);
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
            re=false;
        } catch (ClientException e) {
            e.printStackTrace();
            re= false;
        }

        return  re;

    }
   // 订单通知短信
    public  boolean sendMessage2(String typeTemplate,String phoneNumber,String oid,String fromaddress,String toaddress,String sijiPhone){

        DefaultProfile profile = DefaultProfile.getProfile("自贡", keyID, secrect);
        //  DefaultProfile profile = DefaultProfile.getProfile("自贡", "LTAIETmbl8VB0OYY", "MNgh412fbGSaBhWuLxlNdCB4GJivOu");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "自贡");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", "速安");
        request.putQueryParameter("TemplateCode", typeTemplate);
        request.putQueryParameter("TemplateParam", "{\"oid\":\""+oid+"\",\"fromaddress\":\""+fromaddress+"\""+",\"toaddress\":\""+toaddress+"\""+",\"phone\":\""+sijiPhone+"\""+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
            return  false;
        } catch (ClientException e) {
            e.printStackTrace();
            return  false;
        }

        return  true;

    }



}
