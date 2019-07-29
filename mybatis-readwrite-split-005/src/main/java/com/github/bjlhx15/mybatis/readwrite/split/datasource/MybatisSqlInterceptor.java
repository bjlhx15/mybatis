package com.github.bjlhx15.mybatis.readwrite.split.datasource;

import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;

import javax.annotation.Resource;
import java.sql.Connection;
import java.util.Properties;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class ,Integer.class}) })
public class MybatisSqlInterceptor implements Interceptor {
    @Resource(name = "shardingDataSourceRouter")
    private ShardingDataSourceRouter shardingDataSourceRouter;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println(1);
        if(invocation.getTarget() instanceof RoutingStatementHandler){
            RoutingStatementHandler statementHandler = (RoutingStatementHandler) invocation.getTarget();
            BoundSql boundSql = statementHandler.getBoundSql();
            String sql = boundSql.getSql().toUpperCase();
            String tableName="";
            Object parmaters=null;

            if(sql.startsWith("INSERT INTO")){
                tableName="accountbalance";//this.getTableName(sql);
                parmaters=boundSql.getParameterObject();
                shardingDataSourceRouter.doRoute(tableName,parmaters);
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
