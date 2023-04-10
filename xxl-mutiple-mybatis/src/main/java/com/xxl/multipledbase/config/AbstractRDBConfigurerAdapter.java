package com.xxl.multipledbase.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.StringUtils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import javax.sql.DataSource;

import com.xxl.multipledbase.handler.DynamicDataSource;
import com.xxl.multipledbase.util.MultiDBProperties;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

public abstract class AbstractRDBConfigurerAdapter {
    private static final Logger log = LoggerFactory.getLogger(AbstractRDBConfigurerAdapter.class);
    private static Map<Object, Object> dataSourceMap;
    private static Map<String, Map<String, String>> dataSourceAttrMap = new HashMap();
    private static final String DEFAULT = "default";
    private static final String IS_SECRET = "unif.datasource.db.isSecret";
    private static final String RDB_CONFIG_KEY_PREFIX = "unif.rdb.";
//    private static final String[] decryptKeys = new String[]{"username", "password"};

    public Properties properties;
    private Properties defaultProperties = new Properties();

    public AbstractRDBConfigurerAdapter() {
    }

    @Bean
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> dataSourceMap = this.getDataSourceMap();
        Iterator var3 = dataSourceMap.entrySet().iterator();

        while(var3.hasNext()) {
            Entry<Object, Object> entry = (Entry)var3.next();
            if (StringUtils.equalsIgnoreCase("default", entry.getKey().toString())) {
                dynamicDataSource.setDefaultDataSource(entry.getValue());
                break;
            }
        }

        dynamicDataSource.setDataSources(dataSourceMap);
        dynamicDataSource.afterPropertiesSet();
        return dynamicDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DynamicDataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        return transactionManager;
    }

    private Map<Object, Object> getDataSourceMap() {
        if (dataSourceMap != null) {
            return dataSourceMap;
        } else {
//            boolean isSecret = UnifProperties.getPropertyForBoolean("unif.base.db.isSecret", "false");
            dataSourceMap = new HashMap();
            Properties properties = MultiDBProperties.getProperties();
            Enumeration keys = properties.propertyNames();

            while(keys.hasMoreElements()) {
                String unifConfigKey = (String)keys.nextElement();
                String unifConfigValue = (String)properties.get(unifConfigKey);
                if (unifConfigKey.startsWith("unif.rdb.")) {
                    this.checkConfigKey(unifConfigKey);
                    String dataSourceName = this.getDataSourceName(unifConfigKey);
                    Map<String, String> dsAttr = (Map)dataSourceAttrMap.get(dataSourceName);
                    if (dsAttr == null) {
                        dsAttr = new HashMap();
                        dataSourceAttrMap.put(dataSourceName, dsAttr);
                    }


                    ((Map)dsAttr).put(this.getDataSourceAttributeKey(unifConfigKey), unifConfigValue);
                }
            }

            this.checkDefault();
            Iterator var10 = dataSourceAttrMap.entrySet().iterator();

            while(var10.hasNext()) {
                Entry<String, Map<String, String>> dsAttr = (Entry)var10.next();
                dataSourceMap.put(dsAttr.getKey(), this.getDataSource((String)dsAttr.getKey(), (Map)dsAttr.getValue()));
            }

            return dataSourceMap;
        }
    }

    private void checkDefault() {
        Map<String, String> defaultDBconfig = (Map)dataSourceAttrMap.get("default");
        if (MapUtils.isEmpty(defaultDBconfig)) {
            String message = String.format("database default config missing，config name must start with [%1$s]", "spring.datasource.".concat("default"));
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void checkConfigKey(String unifConfigKey) {
        if (unifConfigKey.split("\\.").length != 4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private String getDataSourceName(String unifConfigKey) {
        return unifConfigKey.split("\\.")[2];
    }

    private String getDataSourceAttributeKey(String unifConfigKey) {
        return unifConfigKey.split("\\.")[3];
    }

    private DataSource getDataSource(String dataSourceName, Map<String, String> dsAttrMap) {
        try {
            DruidDataSource dataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(dsAttrMap);
            List<Filter> filters = this.initProxyFilters();
            if (CollectionUtils.isNotEmpty(filters)) {
                dataSource.setProxyFilters(filters);
            }

            return dataSource;
        } catch (Exception var5) {
            String message = "create datasource with config [" + dataSourceName + "] failure";
            throw new ArrayIndexOutOfBoundsException();
        }
    }

//    private boolean neadDecrypt(String key) {
//        boolean isMatch = false;
//        String[] var3 = decryptKeys;
//        int var4 = var3.length;

//        for(int var5 = 0; var5 < var4; ++var5) {
//            String decryptKey = var3[var5];
//            String pattern = "spring.datasource.*." + decryptKey;
//            isMatch = Pattern.matches(pattern, key);
//            if (isMatch) {
//                break;
//            }
//        }
//
//        return isMatch;
//    }

    protected abstract List<Filter> initProxyFilters();
}
