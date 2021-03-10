package com.usian.feign;

import com.usian.fallback.UserServiceFallback;
import com.usian.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ClassName:UserFeign
 * Author:maodi
 * CreateTime:2021/03/09/19:26
 */
//获取eureka-provider的调用地址，且具有负载均衡的能力
@FeignClient(value="eureka-provider",fallback= UserServiceFallback.class)
public interface UserFeign {

    @RequestMapping(value="user/findById/{id}")
    public User getUser(@PathVariable("id") Integer id);

    @RequestMapping(value="user/getAll")
    public List<User> getUser();
}
