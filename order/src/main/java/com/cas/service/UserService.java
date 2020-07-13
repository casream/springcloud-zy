package com.cas.service;

import com.cas.pojo.User;

import java.util.List;

public interface UserService {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    String error() ;
}