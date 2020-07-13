package com.cas.web.service;

import com.cas.pojo.User;

import java.util.List;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2020/7/11 16:13
 * @Created by Administrator
 */
public interface UserService {
    String queryContens();

    String query();

    List<User> selectAll();

    /**
     * 会发生异常
     * @return
     */
    String error();
}
