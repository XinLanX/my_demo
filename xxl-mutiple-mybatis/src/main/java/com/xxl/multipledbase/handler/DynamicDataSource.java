package com.xxl.multipledbase.handler;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import javax.sql.DataSource;
import java.util.Map;

public class DynamicDataSource extends AbstractRoutingDataSource {
    public DynamicDataSource(){

    }

    protected DataSource determineTargetDataSource(){
        return super.determineTargetDataSource();
    }

    protected Object determineCurrentLookupKey(){
        return DynamicDataSourceContextHolder.getDataSourceKey();
    }

    public void setDefaultDataSource(Object defaultDataSource){
        super.setDefaultTargetDataSource(defaultDataSource);
    }

    public void setDataSources(Map<Object, Object> dataSources){
        super.setTargetDataSources(dataSources);
        DynamicDataSourceContextHolder.addDataSourceKeys(dataSources.keySet());
    }
}
