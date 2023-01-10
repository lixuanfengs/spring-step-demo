package com.cactusli.springframework.jdbc.datasource;

import com.cactusli.springframework.jdbc.CannotGetJdbcConnectionException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by cactusli on 2023/1/3 16:33
 */
public abstract class DataSourceUtils {

    public static Connection getConnection(DataSource dataSource) {
        try {
            return doGetConnection(dataSource);
        } catch (SQLException e) {
            throw new CannotGetJdbcConnectionException("Failed to obtain JDBC Connection", e);
        }
    }

    public static Connection doGetConnection(DataSource dataSource) throws SQLException {
        Connection connection = fetchConnection(dataSource);
        ConnectionHolder holderToUse = new ConnectionHolder(connection);

        return connection;
    }

    private static Connection fetchConnection(DataSource dataSource) throws SQLException {
        Connection conn = dataSource.getConnection();
        if (null == conn) {
            throw new IllegalArgumentException("DataSource return null from getConnection():" + dataSource);
        }
        return conn;
    }

    public static void releaseConnection(Connection con, DataSource dataSource) {
        try {
            doReleaseConnection(con, dataSource);
        } catch (SQLException ex) {
//            logger.debug("Could not close JDBC Connection", ex);
        } catch (Throwable ex) {
//            logger.debug("Unexpected exception on closing JDBC Connection", ex);
        }
    }

    public static void doReleaseConnection(Connection con, DataSource dataSource) throws SQLException {
        if (con == null) {
            return;
        }
        doCloseConnection(con, dataSource);
    }

    public static void doCloseConnection(Connection con, DataSource dataSource) throws SQLException {
        con.close();
    }

}