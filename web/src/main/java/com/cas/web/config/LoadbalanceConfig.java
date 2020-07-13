package com.cas.web.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname LoadbalanceConfig
 * @Description TODO
 * @Date 2020/7/10 20:44
 * @Created by Administrator
 */
@Configuration
@RibbonClients(value = {@RibbonClient(name = "micro-order", configuration = RibbonLoadBalanceMicroOrderConfig.class)})
public class LoadbalanceConfig {

}
