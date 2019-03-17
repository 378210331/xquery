package com.hsy.platform.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Map;

/**
 * 异常统一处理器
 */
@ControllerAdvice
public class CommonExceptionHandler extends BaseRestController{

    Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Map<String,Object> NullPointerExceptionHandler(NullPointerException ex){
        logger.error("发生了空指针异常");
        ex.printStackTrace();
        return getResultMap(false,"发生了空指针异常");

    }


    @ExceptionHandler(FileNotFoundException.class)
    @ResponseBody
    public Map<String,Object> FileNotFoundExceptionHandler(FileNotFoundException ex){
        logger.error("发生了文件丢失异常");
        ex.printStackTrace();
        return getResultMap(false,"发生了文件丢失异常");

    }

    /**
     * 处理ArithmeticException异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(ArithmeticException.class)
    public Map<String,Object> dealArithmeticException(ArithmeticException ex) {
        logger.error("算数处理出现异常");
        ex.printStackTrace();
        return getResultMap(false,"算数处理出现异常");
    }


    /**
     * sql异常
     * @param ex
     * @return
     */
    @ExceptionHandler(SQLException.class)
    @ResponseBody
    public Map<String,Object> SQLExceptionHandler(SQLException ex){
        logger.error(ex.getMessage());
        ex.printStackTrace();
        return getResultMap(false,ex.getMessage());

    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> dealCommonException(Exception ex) {
        logger.error("公共异常");
        ex.printStackTrace();
        return getResultMap(false,"公共异常处理");
    }
}
