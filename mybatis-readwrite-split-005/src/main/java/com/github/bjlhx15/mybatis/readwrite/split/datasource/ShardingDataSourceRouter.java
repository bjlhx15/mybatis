package com.github.bjlhx15.mybatis.readwrite.split.datasource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ShardingDataSourceRouter implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
    @Resource(name="dataSourceConfig")
    private DataSourceConfig dataSourceConfig;

    public void doRoute(String tableName,Object paramters){
        int dsIndex=0;
        List<String> dataSourceKeys = dataSourceConfig.getDataSourceKeys();
        String[] beanNames = applicationContext.getBeanNamesForType(ShardingDataSourceRule.class);
        for (String beanName : beanNames) {
            ShardingDataSourceRule shardingDataSourceRule = applicationContext.getBean(beanName, ShardingDataSourceRule.class);
            if(tableName.equalsIgnoreCase(shardingDataSourceRule.getShardingTableName())){
                dsIndex=shardingDataSourceRule.doSharding(paramters,dataSourceKeys.size());
                break;
            }
        }
        String dsKey = dataSourceConfig.getDataSourceKeys().get(dsIndex);
        ShardingContextHolder.setDataSourceKey(dsKey);
    }
}
