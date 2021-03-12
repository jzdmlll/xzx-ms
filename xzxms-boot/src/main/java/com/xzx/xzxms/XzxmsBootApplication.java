package com.xzx.xzxms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@MapperScan(value = { "com.xzx.xzxms.*.dao"})
public class XzxmsBootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(XzxmsBootApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(XzxmsBootApplication.class);
    }
}
