package com.github.bjlhx15.mybatis.readwrite.split.datasource;

public abstract class ShardingDataSourceRule {
    private String shardingTableName;

    public String getShardingTableName() {
        return shardingTableName;
    }

    public void setShardingTableName(String shardingTableName) {
        this.shardingTableName = shardingTableName;
    }
    public Integer doSharding(Object paramter,Integer dataSourceKeys){
        return 0;
    }
}
