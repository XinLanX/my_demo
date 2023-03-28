package com.xxl.multipledb.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

//    @Primary
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.db1")
//    public DataSourceProperties db1DataSourceProperties(){
//        return new DataSourceProperties();
//    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource db1(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource db2(){
        return DruidDataSourceBuilder.create().build();
    }

//
//    @Primary
//    @Bean(name = "db1DataSource")
//    public DataSource db1DataSource(@Qualifier("db1DataSourceProperties") DataSourceProperties dataSourceProperties){
//        return dataSourceProperties.initializeDataSourceBuilder().build();
//    }
//
//    @Bean(name = "db2DataSourceProperties")
//    @ConfigurationProperties(prefix = "spring.datasource.db2")
//    public DataSourceProperties db2DataSourceProperties(){
//        return new DataSourceProperties();
//    }
//
//    @Bean(name = "db2DataSource")
//    public DataSource db2DataSource(@Qualifier("db2DataSourceProperties") DataSourceProperties dataSourceProperties){
//        return dataSourceProperties.initializeDataSourceBuilder().build();
//    }



}
