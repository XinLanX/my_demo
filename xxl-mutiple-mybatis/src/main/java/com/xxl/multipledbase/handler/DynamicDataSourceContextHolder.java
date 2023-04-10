package com.xxl.multipledbase.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DynamicDataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>() {
        protected String initialValue() {
            return "default";
        }
    };
    public static List<Object> dataSourceKeys = new ArrayList();

    public DynamicDataSourceContextHolder() {
    }

    public static void setDataSourceKey(String key) {
        contextHolder.set(key);
    }

    public static String getDataSourceKey() {
        return (String)contextHolder.get();
    }

    public static void clearDataSourceKey() {
        contextHolder.remove();
    }

    public static boolean containDataSourceKey(String key) {
        return dataSourceKeys.contains(key);
    }

    public static boolean addDataSourceKeys(Collection<? extends Object> keys) {
        return dataSourceKeys.addAll(keys);
    }

    public static List<Object> getDataSourceKeys() {
        return dataSourceKeys;
    }
}