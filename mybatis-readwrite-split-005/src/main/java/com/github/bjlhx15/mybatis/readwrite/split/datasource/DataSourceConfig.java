package com.github.bjlhx15.mybatis.readwrite.split.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DataSourceConfig {
    @Autowired
    ShardingRoutingDataSource shardingRoutingDataSource;
    private List<String> dataSourceKeys;

    public List<String> getDataSourceKeys() {
        return dataSourceKeys;
    }

    public void setDataSourceKeys(List<String> dataSourceKeys) {
        List<String> dataSourceKeys2=new ArrayList<>();
        dataSourceKeys2.add("write");
        dataSourceKeys2.add("read");
        this.dataSourceKeys = dataSourceKeys2;
    }
}
