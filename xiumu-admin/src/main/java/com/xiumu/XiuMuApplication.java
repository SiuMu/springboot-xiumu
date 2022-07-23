package com.xiumu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.xiumu.dao")
@SpringBootApplication
public class XiuMuApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(XiuMuApplication.class, args);
    }
}
