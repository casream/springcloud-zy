package com.cas.web.config;

import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname RibbonLoadBalanceMicroOrderConfig
 * @Description TODO
 * @Date 2020/7/10 22:20
 * @Created by Administrator
 */
@Configuration

public class RibbonLoadBalanceMicroOrderConfig {
    private String name = "micro-order";

    @Bean
    @ConditionalOnClass
    public IClientConfig defaultClientConfigImpl() {
        DefaultClientConfigImpl config = new DefaultClientConfigImpl();
        config.loadProperties(name);
        config.set(CommonClientConfigKey.ReadTimeout, 60000);
        config.set(CommonClientConfigKey.MaxAutoRetries, 2);
        config.set(CommonClientConfigKey.MaxAutoRetriesNextServer, 2);
        config.set(CommonClientConfigKey.ConnectTimeout, 6000);
        config.set(CommonClientConfigKey.OkToRetryOnAllOperations, true);
        return config;
    }

    @Bean
    public IRule randomRule() {
        new WeightedResponseTimeRule();
        new RoundRobinRule();
        new BestAvailableRule();
        return new RandomRule();
    }
}
