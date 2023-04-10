package com.xxl.multipledbase.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Order(-1)
@Component
public class DynamicDataSourceAspect {
    private static final Logger log = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    public DynamicDataSourceAspect() {
    }

    @Before("@annotation(dataSource))")
    public void switchDataSource(JoinPoint point, DataSource dataSource) {
        if (!DynamicDataSourceContextHolder.containDataSourceKey(dataSource.value())) {
            log.info("DataSource [{}] doesn't exist, use default DataSource [{}] " + dataSource.value());
        } else {
            DynamicDataSourceContextHolder.setDataSourceKey(dataSource.value());
            log.info("Switch DataSource to [" + DynamicDataSourceContextHolder.getDataSourceKey() + "] in Method [" + point.getSignature() + "]");
        }

    }

    @After("@annotation(dataSource))")
    public void restoreDataSource(JoinPoint point, DataSource dataSource) {
        DynamicDataSourceContextHolder.clearDataSourceKey();
        log.info("Restore DataSource to [" + DynamicDataSourceContextHolder.getDataSourceKey() + "] in Method [" + point.getSignature() + "]");
    }
}
