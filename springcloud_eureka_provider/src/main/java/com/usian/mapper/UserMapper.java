package com.usian.mapper;

import com.usian.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName:UserMapper
 * Author:maodi
 * CreateTime:2021/03/09/20:26
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    User getUserById(Integer id);

    @Select("select  * from user")
    List<User> getAll();

}
