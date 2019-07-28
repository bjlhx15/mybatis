package com.github.bjlhx15.mybatis.readwrite.split.datasource;

import java.sql.Connection;

/**
 * Desc: 创建Connection代理接口
 */
public interface ConnectionProxy extends Connection {

    /**
     * 根据传入的读写分离需要的key路由到正确的connection
     *
     * @param key 数据源标识
     * @return
     */
    Connection getTargetConnection(String key);
}
