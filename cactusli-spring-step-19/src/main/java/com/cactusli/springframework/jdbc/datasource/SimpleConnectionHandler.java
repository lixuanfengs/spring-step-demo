package com.cactusli.springframework.jdbc.datasource;

import cn.hutool.core.lang.Assert;

import java.sql.Connection;

/**
 * Created by cactusli on 2023/1/3 16:35
 */
public class SimpleConnectionHandler  implements ConnectionHandler{
    private final Connection connection;

    public SimpleConnectionHandler(Connection connection) {
        Assert.notNull(connection, "Connection must not be null");
        this.connection = connection;
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }
}
