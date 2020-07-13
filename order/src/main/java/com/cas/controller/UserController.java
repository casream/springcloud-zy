package com.cas.controller;

import com.cas.pojo.User;
import com.cas.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2020/7/10 12:28
 * @Created by Administrator
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userServcie;

    @Value("${server.port}")
    private int port;

    @RequestMapping("/query")
    public String query() {
        log.info(port + "=============UserController.query==========");
        return "==query something=======";
    }

    @RequestMapping("/queryContens")
    public String queryContens() {
        log.info(port + Thread.currentThread().getName() + "=============queryContens==========");
        return "==queryContens=======";
    }

    @RequestMapping("/selectAll")
    public List<User> selectAll() {
        log.info(port + Thread.currentThread().getName() + "=============selectAll==========");
        return userServcie.selectAll();
    }

    @RequestMapping("/error1")
    public String error()  {
        log.info(port + Thread.currentThread().getName() + "=============error==========");
        return userServcie.error();
    }
}
