package com.xzx.xzxms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.xzx.xzxms.*.dao")
public class MybatisConfig {

}
