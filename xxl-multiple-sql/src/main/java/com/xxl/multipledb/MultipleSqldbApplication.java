package com.xxl.multipledb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@MapperScan(value = {"com.xxl.multipledb.dao"})
@Configuration
public class MultipleSqldbApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultipleSqldbApplication.class);
    }

}
