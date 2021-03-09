package com.usian;

/**
 * ClassName:EurekaApp
 * Author:maodi
 * CreateTime:2021/03/09/15:46
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer//EurekaServer服务器端启动类，接受其他微服务注册进来
@SpringBootApplication
public class EurekaApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApp.class, args);
    }
}
