package usian.service;

import com.usian.pojo.User;

import java.util.List;

/**
 * ClassName:UserService
 * Author:maodi
 * CreateTime:2021/03/09/16:03
 */
public interface UserService {

    User getUser(Integer id);

    List<User> getUser();

}
