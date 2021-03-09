package com.usian.pojo;

/**
 * ClassName:User
 * Author:maodi
 * CreateTime:2021/03/09/15:55
 */
public class User {
    private Integer id;
    private String nam;
    private Integer age;

    public User() {
    }

    public User(Integer id, String nam, Integer age) {
        this.id = id;
        this.nam = nam;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
