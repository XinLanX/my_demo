package com.xxl.multipledbase;


//import com.xxl.multipledbase.config.DbConfig;
import com.xxl.multipledbase.config.UnifConfigApplicationInitiallizer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@SpringBootApplication(exclude = {RabbitAutoConfiguration.class})
//@EnableAspectJAutoProxy
//@MapperScan(value = {"com.xxl.multipledbase.dao"})
//@ComponentScan(basePackages = {"com.xxl.multipledbase.dao", "com.xxl.multipledbase.controller", "com.xxl.multipledbase.service"})
//@Configuration
//@Import(value = {DbConfig.class})
public class MultipleMybatisApplication {
    public static void main(String[] args) {
//        SpringApplication.run(MultipleMybatisApplication.class);
        SpringApplication springApplication = new SpringApplication(MultipleMybatisApplication.class);
        springApplication.addInitializers(new UnifConfigApplicationInitiallizer());
        ConfigurableApplicationContext context = springApplication.run(args);
    }

}
