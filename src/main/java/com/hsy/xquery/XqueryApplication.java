package com.hsy.xquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan("com.hsy")
public class XqueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(XqueryApplication.class, args);
    }

}
