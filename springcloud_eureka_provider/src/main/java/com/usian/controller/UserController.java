package com.usian.controller;

import com.usian.pojo.User;
import com.usian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:UserController
 * Author:maodi
 * CreateTime:2021/03/09/16:04
 */
@RestController

public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("user/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

}
