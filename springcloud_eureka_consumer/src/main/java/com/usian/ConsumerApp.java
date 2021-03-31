package com.usian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName:ConsumerApp
 * Author:maodi
 * CreateTime:2021/03/09/16:07
 */
//允许向注册中心注册该服务，并可以获取其他服务的调用地址
    /*注解@SpringCloudApplication包括：
@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker
分别是SpringBoot注解、注册服务中心Eureka注解、断路器注解。
使用@SpringCloudApplication需要进入Springboot依赖外，还需要引入以下的两个依赖*/
@EnableEurekaClient
@EnableFeignClients//开启feign接口扫描
@SpringCloudApplication
public class ConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class, args);
    }
}
