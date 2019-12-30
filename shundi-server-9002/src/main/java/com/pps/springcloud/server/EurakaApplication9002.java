package com.pps.springcloud.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Classname EurakaApplication7001
 * @Description
 * @@Author Pupansheng
 * @Date 2019/9/30 14:18
 * @Vestion 1.0
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurakaApplication9002 {

    public  static  void  main(String ...args){


        SpringApplication.run(EurakaApplication9002.class,args);

    }
}
