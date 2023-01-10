package com.cactusli.springframework.jdbc.support;

import com.cactusli.springframework.beans.factory.InitializingBean;

import javax.sql.DataSource;

/**
 * Created by cactusli on 2023/1/3 17:22
 */
public class JdbcAccessor implements InitializingBean {

    private DataSource dataSource;


    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected DataSource obtainDataSource() {
        return getDataSource();
    }

    @Override
    public void afterPropertiesSet() {
        if (null == getDataSource()) {
            throw new IllegalArgumentException("Property 'datasource' is required");
        }
    }
}
