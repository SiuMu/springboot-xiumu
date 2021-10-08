package com.xiumu.springbootxiumu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xiumu.springbootxiumu.mapper")
@SpringBootApplication
public class SpringbootXiumuApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootXiumuApplication.class, args);
    }

}
