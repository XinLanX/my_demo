package com.xxl.multipledbase.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Properties;

public class RDBSupportCondition implements Condition {
    private static Properties properties;
    public RDBSupportCondition() {
    }

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        return properties.getProperty("unif.base.db.type", "rdb").equals("rdb");
        return true;
    }
}