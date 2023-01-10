package service.impl;

import com.cactusli.springframework.jdbc.support.JdbcTemplate;
import com.cactusli.springframework.tx.transaction.annotation.Transactional;
import service.JdbcService;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by cactusli on 2023/1/4 16:33
 */
public class JdbcServiceImpl implements JdbcService {

    private Statement statement;

    public JdbcServiceImpl() {}

    public JdbcServiceImpl(Statement statement) {
        this.statement = statement;
    }

    @Override
    public void saveDataWithTranslation() throws SQLException {

        statement.execute("insert into teacher(teacher_name) values ('赵老师')");

        statement.execute("insert into user(id,username) values(9,'重复数据1')");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveData(JdbcTemplate jdbcTemplate) {
        jdbcTemplate.execute("insert into teacher(teacher_name) values ('李老师')");
        jdbcTemplate.execute("insert into user(id,username) values(9,'重复数据')");
    }
}
