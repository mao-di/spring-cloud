package com.usian.controller;

import com.usian.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:UserController
 * Author:maodi
 * CreateTime:2021/03/09/16:08
 */
@RestController
public class UserController {

    //从eureka注册中心获取服务端的ip、端口、要调用的服务
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    //访问Rest服务的客户端
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="consumer/user/{id}",method= RequestMethod.GET)
    public User getUserBy(@PathVariable Integer id){
        ServiceInstance si = loadBalancerClient.choose("eureka-provider");
        //指定要调用的服务
        String url = "http://"+si.getHost()+":"+si.getPort()+"/user/"+id;
        return restTemplate.getForObject(url, User.class);
    }
}
