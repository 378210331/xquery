package com.hsy.platform.controller;

import com.hsy.platform.entity.Page;
import com.hsy.platform.entity.PageData;
import com.hsy.platform.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@Api(value="登录处理")
public class LoginController extends  BaseRestController {

    @Resource
    UserService userService;

    Logger logger = LoggerFactory.getLogger(LoginController.class);


    @ApiOperation(value="登录页", notes="登录页" ,httpMethod="POST")
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


    @ApiOperation(value="登录请求", notes="登录请求" ,httpMethod="POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name="loginName", value="用户姓名", dataType = "String", required=true, paramType="form"),
            @ApiImplicitParam(name="LoginPasswrd", value="用户密码", dataType = "String", required=true, paramType="form")
    })
    @PostMapping("login")
    public Map<String,Object> login() throws Exception {
        // autoLogin();
        return getResultMap(true,"login");
    }

    /**
     * 自动登录
     */
    private void autoLogin()  {
        UsernamePasswordToken token = new UsernamePasswordToken("super", "super");
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        Subject currentUser = SecurityUtils.getSubject();
    }
}
