package com.github.bjlhx15.mybatis.readwrite.split.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc: 动态数据源实现读写分离
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private Object writeDataSource;//写数据源
    private Object readDataSource; //读数据源


    @Override public void afterPropertiesSet() {
        if (this.writeDataSource == null) {
            throw new IllegalArgumentException("Property 'writeDataSource' is required");
        }
        setDefaultTargetDataSource(writeDataSource);
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DynamicDataSourceGlobal.WRITE.name(), writeDataSource);
        targetDataSources.put(DynamicDataSourceGlobal.READ.name(), readDataSource);
        setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }


    @Override protected Object determineCurrentLookupKey() {
        DynamicDataSourceGlobal dynamicDataSourceGlobal = DynamicDataSourceHolder.getDataSource();
        if (dynamicDataSourceGlobal == null || dynamicDataSourceGlobal == DynamicDataSourceGlobal.WRITE) {
            return DynamicDataSourceGlobal.WRITE.name();
        }
        return DynamicDataSourceGlobal.READ.name();
    }


    public void setWriteDataSource(Object writeDataSource) {
        this.writeDataSource = writeDataSource;
    }


    public Object getWriteDataSource() {
        return writeDataSource;
    }


    public Object getReadDataSource() {
        return readDataSource;
    }


    public void setReadDataSource(Object readDataSource) {
        this.readDataSource = readDataSource;
    }
}
