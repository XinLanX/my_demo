package com.xxl.multipledbase.config;

import com.alibaba.druid.filter.Filter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Conditional({RDBSupportCondition.class})
@ComponentScan(
        basePackages = {"com.xxl.multipledbase"}
)
@Configuration
public class RDBConfigurerAdapter extends AbstractRDBConfigurerAdapter {
    public RDBConfigurerAdapter() {
    }

    protected List<Filter> initProxyFilters() {
        return Collections.emptyList();
    }
}