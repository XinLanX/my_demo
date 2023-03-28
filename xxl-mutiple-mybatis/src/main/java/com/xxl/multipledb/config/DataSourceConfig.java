package com.xxl.multipledb.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.xxl.multipledb.dao", sqlSessionFactoryRef = "db1SqlSessionFactory")
public class DataSourceConfig {

    @Bean(name = "db1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    @Primary
    public DataSource db1DataSourceProperties(){
        return DataSourceBuilder.create().build();
    }

    @Bean("db1SqlSessionFactory")
    @Primary
    public SqlSessionFactory db1SessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "db1TransactionManager")
    @Primary
    public DataSourceTransactionManager db1TransactionManager(@Qualifier("db1DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("db1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
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
