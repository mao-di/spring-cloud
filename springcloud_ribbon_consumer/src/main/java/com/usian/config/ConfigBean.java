package com.usian.config;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:ConfigBean
 * Author:maodi
 * CreateTime:2021/03/09/16:35
 */
@Configuration
public class ConfigBean {

    //默认使用轮循的策略
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    //随机策略
    @Bean
    public RandomRule getRuleribbonRule() {
        return new RandomRule();
    }

}