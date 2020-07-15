package com.cas.controller;

import com.cas.pojo.User;
import com.cas.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2020/7/10 12:28
 * @Created by Administrator
 */
@RefreshScope
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userServcie;

    @Value("${server.port}")
    private int port;

    @Value("${username}")
    private String username;


    @Autowired
    Environment environment;

    @RequestMapping("/getInfo")
    public String getInfo() {
        String str = "===Value=username：" + username + "====redisPwd：" + environment.getProperty("redis.password") ;
        log.info("=======Environment：" + environment.getProperty("username"));
        log.info("=====Value:" +username);
        log.info(str);
        return str;
    }


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
    public String error() {
        log.info(port + Thread.currentThread().getName() + "=============error==========");
        return userServcie.error();
    }
}
