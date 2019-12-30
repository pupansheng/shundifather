package com.pps.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;
import java.nio.charset.Charset;

/**
 * @Classname WebConfig
 * @Description
 * @@Author Pupansheng
 * @Date 2019/6/27 23:31
 * @Vestion 1.0
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 设置响应的字符编码
     * @return
     */
    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter =new FastJsonHttpMessageConverter();
        FastJsonConfig config= new FastJsonConfig();
        config.setDateFormat("yyyy-MM-dd");//日期格式
        config.setCharset(Charset.forName("UTF-8"));//数据编码
        config.setSerializerFeatures(
                /*SerializerFeature.WriteClassName,*///是否在生成的json中输出类名
                SerializerFeature.WriteMapNullValue//是否输出value为null的字符串
              /*  SerializerFeature.PrettyFormat*/,//生成的json格式化
                SerializerFeature.WriteNullListAsEmpty,//空集合输出【】而非null
                SerializerFeature.WriteNullStringAsEmpty//空字符串输出“”而不是null
        );
        //配置完之后还需要在config里面响应一下编码
        fastJsonHttpMessageConverter.setFastJsonConfig(config);
        return fastJsonHttpMessageConverter;
    }
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize("10MB"); // KB,MB
        /// 总上传数据大小
        factory.setMaxRequestSize("100MB");
        factory.setLocation("c://uploadtest");
        return factory.createMultipartConfig();
    }



}
