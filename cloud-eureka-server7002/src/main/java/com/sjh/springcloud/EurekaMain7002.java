package com.sjh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author SJH
 * @create 2020/5/7
 */
@SpringBootApplication
@EnableEurekaServer         //标明服务注册中心，来管理配置登记
public class EurekaMain7002 {
    public static void main(String[] args){
        SpringApplication.run(EurekaMain7002.class,args);
    }
}
