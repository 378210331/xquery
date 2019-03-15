package com.hsy.platform.controller;

import com.hsy.platform.entity.Page;
import com.hsy.platform.entity.PageData;
import com.hsy.platform.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class LoginController extends  BaseRestController {

    @Resource
    UserService userService;

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/")
    public Map<String,Object> test(){
            logger.error("测试");
            autoLogin();
            return getResultMap(true,"hello-world");
    }

    @RequestMapping("index")
    public Page index() throws Exception {
       PageData pd =  userService.getUserByLoginName("super");
        Page page =  getPage();
        page.setPd(pd);
        return page;
    }

    @RequestMapping("login")
    public Map<String,Object> login() throws Exception {
        // autoLogin();
        return getResultMap(true,"login");
    }


    private void autoLogin()  {
        UsernamePasswordToken token = new UsernamePasswordToken("super", "super");
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        Subject currentUser = SecurityUtils.getSubject();
    }
}
