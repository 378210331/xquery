package com.hsy.platform.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorPageController implements ErrorController {

    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping("/error")
    public String handleError() {
        return "error.html"; // 该资源位于resources/static目录下
    }
}
