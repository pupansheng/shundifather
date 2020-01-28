package com.pps.config.compont;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Classname MailConfig
 * @Description
 * @@Author Pupansheng
 * @Date 2020/1/13 10:07
 * @Vestion 1.0
 **/
@Component
@ConfigurationProperties("mailProperty")
public class MailConfig {

    private List<Map<String,String>> client;

    public List<Map<String, String>> getClient() {
        return client;
    }

    public void setClient(List<Map<String, String>> client) {
        this.client = client;
    }
}
