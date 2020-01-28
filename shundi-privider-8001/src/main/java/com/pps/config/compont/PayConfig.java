package com.pps.config.compont;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Classname PayConfig
 * @Description
 * @@Author Pupansheng
 * @Date 2019/7/1 17:11
 * @Vestion 1.0
 **/
@Component
@ConfigurationProperties(prefix = "pay")
@PropertySource(value = "classpath:payConfig.properties")
public class PayConfig {

    private  String appId;
    private  String public_key;
    private  String private_key;
    private  String alipay_public_key;

    public String getAlipay_public_key() {
        return alipay_public_key;
    }

    public void setAlipay_public_key(String alipay_public_key) {
        this.alipay_public_key = alipay_public_key;
    }

    private  String formate;
    private  String signType;
    private  String encoding;
    private  String serverUrl;
    private  String notifyUrl;
    private  String returnUrl;

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPublic_key() {
        return public_key;
    }

    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }

    public String getPrivate_key() {
        return private_key;
    }

    public void setPrivate_key(String private_key) {
        this.private_key = private_key;
    }

    public String getFormate() {
        return formate;
    }

    public void setFormate(String formate) {
        this.formate = formate;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    @Override
    public String toString() {
        return "PayConfig{" +
                "appId='" + appId + '\'' +
                ", public_key='" + public_key + '\'' +
                ", private_key='" + private_key + '\'' +
                ", formate='" + formate + '\'' +
                ", signType='" + signType + '\'' +
                ", encoding='" + encoding + '\'' +
                ", serverUrl='" + serverUrl + '\'' +
                '}';
    }
}
