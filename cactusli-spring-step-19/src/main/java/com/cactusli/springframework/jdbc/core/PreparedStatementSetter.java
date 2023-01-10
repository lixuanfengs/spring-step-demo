package com.cactusli.springframework.jdbc.core;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by cactusli on 2023/1/3 16:39
 */
public interface PreparedStatementSetter {

    void setValues(PreparedStatement ps) throws SQLException;

}
