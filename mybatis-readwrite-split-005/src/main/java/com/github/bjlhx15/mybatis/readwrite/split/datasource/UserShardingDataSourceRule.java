package com.github.bjlhx15.mybatis.readwrite.split.datasource;

import com.github.bjlhx15.mybatis.readwrite.split.model.auto.AccountBalance;

public class UserShardingDataSourceRule extends ShardingDataSourceRule {
    @Override
    public Integer doSharding(Object paramter, Integer dataSourceKeys) {
        if (paramter instanceof AccountBalance) {
            AccountBalance balance = (AccountBalance) paramter;
            return balance.getId() % dataSourceKeys;
        }
        return 0;
    }
}
