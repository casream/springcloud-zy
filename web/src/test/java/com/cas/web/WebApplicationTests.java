package com.cas.web;

import com.alibaba.fastjson.JSON;
import com.cas.web.service.UserService;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
@WebAppConfiguration
@ContextConfiguration
class WebApplicationTests {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;
    @Rule
    public ContiPerfRule contiPerfRule = new ContiPerfRule();


    @Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mock;

    private Integer count = 1;
    CountDownLatch cdl = new CountDownLatch(count);

    @Before
    public void init() {
        mock = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    @Test
    public void contextLoads() throws Exception {
        MvcResult result = mock.perform(MockMvcRequestBuilders.post("/groupManager")
                .param("pageNum", "1")
                .param("pageSize", "10")).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String content = response.getContentAsString();
        /*List<JtInfoDto> jtInfoDtoList = GsonUtils.toObjects(content, new TypeToken<List<JtInfoDto>>() {}.getType());
        for(JtInfoDto infoDto : jtInfoDtoList){
            System.out.println(infoDto.getJtCode());
        }*/
    }

    @org.junit.Test
    @PerfTest(invocations = 11, threads = 11)
    public void hystrixTest() throws Exception {
        logger.info(Thread.currentThread().getName() + "==>" + JSON.toJSONString(userService.selectAll()));
    }

    @Test
    public void test() {
        for (Integer i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        cdl.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    logger.info(Thread.currentThread().getName() + "==>" + userService.selectAll());
                }
            }).start();
            cdl.countDown();
        }

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void requet() {
        MvcResult result = null;
        try {
            result = mock.perform(MockMvcRequestBuilders.get("/simple")).andReturn();
            MockHttpServletResponse response = result.getResponse();
            ;
            logger.info(response.getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
