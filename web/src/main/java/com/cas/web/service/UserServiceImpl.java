package com.cas.web.service;

import com.cas.pojo.User;
import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.annotation.ObservableExecutionMode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2020/7/10 12:34
 * @Created by Administrator
 */
@Service
@Slf4j
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;
    private final String app = "micro-order";
    private AtomicInteger s = new AtomicInteger(1);

    @Override
    @HystrixCommand(
            commandKey = "userSelectAll",
            fallbackMethod = "exceptionHandler",
            observableExecutionMode = ObservableExecutionMode.LAZY,
            commandProperties = {@HystrixProperty(name = "execution.isolation.strategy", value = "THREAD")},
            threadPoolKey = "hystrixJackpool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "10")
            })
    public List<User> selectAll() {
        log.info(s.getAndIncrement() + ":" + Thread.currentThread().getName() + "========selectAll============");
        return restTemplate.getForObject("http://" + app + "/selectAll", List.class);
    }

    @Override
    @HystrixCommand
    public String error() {
        log.info(s.getAndIncrement() + ":" + Thread.currentThread().getName() + "========error============");
        return restTemplate.getForObject("http://" + app + "/error1", String.class);
    }

    @HystrixCommand(
            fallbackMethod = "queryContentsFallback",
            commandKey = "queryContents",
            groupKey = "querygroup-one",
            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests", value = "100"),
                    @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000000000")
            },
            threadPoolKey = "queryContentshystrixJackpool", threadPoolProperties = {
//            @HystrixProperty(name = "coreSize", value = "100")
    }
    )
    public String queryContens() {
        log.info(s.getAndIncrement() + ":" + Thread.currentThread().getName() + "========queryContens============");
        String string = restTemplate.getForObject("http://" + app + "/queryContens", String.class);
        return string;
    }

    public String queryContentsFallback() {
        log.info("===============queryContentsFallback=================");

        return null;
    }

    @Override
    public String query() {
        return restTemplate.getForObject("http://" + app + "/query", String.class);
    }

    public List<User> exceptionHandler() {
        log.info(Thread.currentThread().getName() + "========error =========exceptionHandler============");
        return Lists.newArrayList();
    }
}
