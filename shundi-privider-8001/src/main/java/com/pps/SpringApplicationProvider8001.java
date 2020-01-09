package com.pps;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @Classname SpringApplicationProvider8001
 * @Description
 * @@Author Pupansheng
 * @Date 2019/9/30 15:26
 * @Vestion 1.0
 **/
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient //服务发现
@MapperScan(basePackages = "com.pps.mapper")
@springfox.documentation.swagger2.annotations.EnableSwagger2
public class SpringApplicationProvider8001 {

    public  static  void  main(String args[]){

        SpringApplication.run(SpringApplicationProvider8001.class,args);



    }


}
