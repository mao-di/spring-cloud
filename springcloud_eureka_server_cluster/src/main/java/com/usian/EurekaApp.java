package com.usian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * ClassName:EurekaApp
 * Author:maodi
 * CreateTime:2021/03/09/16:23
 */
@EnableEurekaServer//EurekaServer服务器端启动类，接受其他微服务注册进来
@SpringBootApplication
public class EurekaApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApp.class, args);
    }
}
