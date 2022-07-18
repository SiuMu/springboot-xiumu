package com.xiumu.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.xiumu.generator.mapper"})
@SpringBootApplication
public class XiuMuGeneratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiuMuGeneratorApplication.class, args);
    }
}
