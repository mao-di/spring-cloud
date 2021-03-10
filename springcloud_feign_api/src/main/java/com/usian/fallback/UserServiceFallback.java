package com.usian.fallback;

import com.usian.feign.UserFeign;
import com.usian.pojo.User;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * ClassName:UserServiceFallback
 * Author:maodi
 * CreateTime:2021/03/10/08:46
 */
@Component
public class UserServiceFallback implements UserFeign {

    @Override
    public User getUser(Integer id) {
        return new User(id,"这是托底数据",0);
    }

    @Override
    public List<User> getUser() {
        return null;
    }
}
