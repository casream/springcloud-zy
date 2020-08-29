package com.cas.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Classname MyTest
 * @Description TODO
 * @Date 2020/7/16 22:40
 * @Created by Administrator
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class MyTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void Test0(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            System.out.println(beanDefinitionName);
        }
    }

}
