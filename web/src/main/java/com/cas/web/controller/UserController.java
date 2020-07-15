package com.cas.web.controller;

import com.alibaba.fastjson.JSON;
import com.cas.web.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2020/7/10 12:56
 * @Created by Administrator
 */
@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private int port;

    @Value("${username}")
    private String username;

    @Autowired
    private Environment environment;

    @RequestMapping("/getInfo")
    public String getInfo() {
        String str = "===Value=username：" + username + "====redisPwd：" + environment.getProperty("redis.password");

        log.info("=======Environment：" + environment.getProperty("username"));
        log.info("=====Value:" + username);
        return str;
    }

    @RequestMapping("/query")
    public String query() {
        return userService.query();
    }

    @RequestMapping("/selectAll")
    public String selectAll() {
        log.info(Thread.currentThread().getName() + "=============selectAll==========");
        return JSON.toJSONString(userService.selectAll());
    }

    @RequestMapping("/queryContens")
    public String queryContens() {
        log.info(Thread.currentThread().getName() + "=============queryContens==========");
        return JSON.toJSONString(userService.queryContens());
    }

    @HystrixCommand
    @RequestMapping("/simple")
    public String simple() {
        log.info(Thread.currentThread().getName() + "=============simple==========");
        return "simple  hystrix test";
    }

    /**
     * 会发生异常
     *
     * @return
     */
    @RequestMapping("/error1")
    public String error() {
        log.info(Thread.currentThread().getName() + "=============error==========");
        return userService.error();
    }
}
