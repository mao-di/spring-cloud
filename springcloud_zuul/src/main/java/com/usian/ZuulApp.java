package com.usian;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
/**
 * ClassName:ZuulApp
 * Author:maodi
 * CreateTime:2021/03/09/21:13
 */
@EnableZuulProxy//开启网关
@EnableEurekaClient//允许向服务端注册服务
@SpringBootApplication
public class ZuulApp {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApp.class, args);
    }
}
