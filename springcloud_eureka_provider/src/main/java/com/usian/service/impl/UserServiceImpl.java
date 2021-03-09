package com.usian.service.impl;

import com.usian.pojo.User;
import com.usian.service.UserService;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserServiceImpl
 * Author:maodi
 * CreateTime:2021/03/09/16:03
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(Integer id) {
        return new User(id,"王粪堆",18);
    }
}
