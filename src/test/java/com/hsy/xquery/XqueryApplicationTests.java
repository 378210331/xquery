package com.hsy.xquery;

import com.hsy.platform.entity.PageData;
import com.hsy.platform.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XqueryApplicationTests {

    @Resource
    UserService userService;

    @Test
    public void contextLoads() throws Exception {
        PageData pd = new PageData();
        pd.addParam("userId","123");
        pd.addParam("loginName","123");
        pd.addParam("loginPassword","123");
        pd.addParam("userName","123");
        userService.save(pd);
    }

}
