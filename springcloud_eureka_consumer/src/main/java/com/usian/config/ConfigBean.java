package com.usian.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:ConfigBean
 * Author:maodi
 * CreateTime:2021/03/09/16:08
 */
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
