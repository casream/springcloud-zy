package com.cas.service.impl;

import com.cas.mapper.UserMapper;
import com.cas.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cas.service.UserService;

import java.util.List;

/**
 * @Classname UserServcieImpl
 * @Description TODO
 * @Date 2020/7/11 15:08
 * @Created by Administrator
 */
@Service
@Slf4j
public class UserServcieImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

    @Override
    public String error() {
        int i= 1/0;
        return "error method ";
    }
}
