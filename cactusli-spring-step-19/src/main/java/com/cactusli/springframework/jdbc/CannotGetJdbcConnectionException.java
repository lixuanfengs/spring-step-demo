package com.cactusli.springframework.jdbc;

import java.sql.SQLException;

/**
 * Created by cactusli on 2023/1/3 16:32
 */
public class CannotGetJdbcConnectionException extends RuntimeException {

    public CannotGetJdbcConnectionException(String message) {
        super(message);
    }

    public CannotGetJdbcConnectionException(String message, SQLException ex) {
        super(message, ex);
    }
}
