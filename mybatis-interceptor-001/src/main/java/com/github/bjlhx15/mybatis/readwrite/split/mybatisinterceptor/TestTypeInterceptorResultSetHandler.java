package com.github.bjlhx15.mybatis.readwrite.split.mybatisinterceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.CallableStatement;
import java.sql.Statement;
import java.util.Properties;

@Intercepts({
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class}),
        @Signature(type = ResultSetHandler.class, method = "handleOutputParameters", args = {CallableStatement.class})})
public class TestTypeInterceptorResultSetHandler implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("TestTypeInterceptorResultSetHandler");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
//        if (target instanceof Executor) {
//            return Plugin.wrap(target, this);
//        } else {
//            return target;
//        }
    }

    @Override
    public void setProperties(Properties properties) { //
    }
}
