package com.usian.service.impl;

import com.netflix.discovery.converters.Auto;
import com.usian.mapper.UserMapper;
import com.usian.pojo.User;
import com.usian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:UserServiceImpl
 * Author:maodi
 * CreateTime:2021/03/09/16:03
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public User getUser(Integer id) {
       return userMapper.getUserById(id);
    }

    @Override
    public List<User> getUser() {
        return userMapper.getAll();
    }
}
