package com.github.bjlhx15.mybatis.readwrite.split.mybatisinterceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.PreparedStatement;
import java.util.Properties;

@Intercepts({
        @Signature(type = ParameterHandler.class, method = "setParameters", args = PreparedStatement.class),
        @Signature(type = ParameterHandler.class, method = "getParameterObject", args = {})
})
public class TestTypeInterceptorParameterHandler implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("TestTypeInterceptorParameterHandler");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
//        if (target instanceof ParameterHandler) {
//            return Plugin.wrap(target, this);
//        } else {
//            return target;
//        }
    }

    @Override
    public void setProperties(Properties properties) { //
    }
}
