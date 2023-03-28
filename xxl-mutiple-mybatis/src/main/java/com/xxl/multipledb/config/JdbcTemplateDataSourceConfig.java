package com.xxl.multipledb.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateDataSourceConfig {
    //JdbcTemplate主数据源ds1数据源
//    @Primary
//    @Bean(name = "db1JdbcTemplate")
//    public JdbcTemplate db1JdbcTemplate(@Qualifier("db1DataSource") DataSource dataSource) {
//
//        return new JdbcTemplate(dataSource);
//    }
//
//    //JdbcTemplate第二个ds2数据源
//    @Bean(name = "db2JdbcTemplate")
//    public JdbcTemplate db2JdbcTemplate(@Qualifier("db2DataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }

    @Bean
    public JdbcTemplate jdbcTemplateDb1(@Qualifier("db1DataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate jdbcTemplateDb2(@Qualifier("db2DataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
