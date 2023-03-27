package com.xxl.myoracle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@MapperScan(value = {"com.xxl.myoracle.keysequence.mapper"})
@Configuration
public class MyoracleApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyoracleApplication.class);
    }
}
