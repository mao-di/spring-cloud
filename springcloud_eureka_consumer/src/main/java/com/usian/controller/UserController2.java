package com.usian.controller;

import com.usian.feign.UserFeign;
import com.usian.pojo.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:UserController2
 * Author:maodi
 * CreateTime:2021/03/09/19:37
 */
@RestController
public class UserController2 {

    @Resource
    private UserFeign userFeign;

    @RequestMapping("user/findById/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userFeign.getUser(id);
    }

    @RequestMapping("user/getAll")
    public List<User> getUser() {
        return userFeign.getUser();
    }

}
