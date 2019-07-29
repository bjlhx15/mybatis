package com.github.bjlhx15.mybatis.readwrite.split.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class ShardingRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return ShardingContextHolder.getDataSourceKey();
    }
}
