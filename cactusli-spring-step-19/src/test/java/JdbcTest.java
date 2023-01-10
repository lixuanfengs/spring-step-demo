import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.Driver;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import service.JdbcService;
import service.impl.JdbcServiceImpl;

import java.lang.reflect.Proxy;
import java.sql.*;

/**
 * Created by cactusli on 2023/1/3 14:39
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JdbcTest {


    /**
     * CREATE TABLE `user` (
     * `id` int NOT NULL AUTO_INCREMENT,
     * `username` varchar(100) DEFAULT NULL,
     * PRIMARY KEY (`id`),
     * UNIQUE KEY `user_id_uindex` (`id`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
     * <p>
     * CREATE TABLE `teacher` (
     * `id` int NOT NULL AUTO_INCREMENT,
     * `teacher_name` varchar(50) NOT NULL,
     * `phone` varchar(20) DEFAULT NULL,
     * PRIMARY KEY (`id`),
     * UNIQUE KEY `teacher_id_uindex` (`id`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
     */
    private DruidDataSource dataSource;

    private Connection connection;

    private Statement statement;

    @BeforeAll
    public void init() throws SQLException {
        dataSource = new DruidDataSource();
        dataSource.setDriver(new Driver());
        dataSource.setUrl("jdbc:mysql://192.168.1.107:3307/oauth2?useSSL=false");
        dataSource.setPassword("root");
        dataSource.setUsername("root");

        connection = dataSource.getConnection().getConnection();

        statement = connection.createStatement();
    }

    @Test
    public void saveDataWithoutTranslation() throws SQLException {

        statement.execute("insert into teacher(teacher_name) values ('李老师')");

        statement.execute("insert into user(id,username) values (9,'重复数据')");
    }

    @Test
    public void saveDataWithTranslation() throws SQLException {

        connection.setAutoCommit(false);
        try {
            statement.execute("insert into teacher(teacher_name) values ('王老师')");

            statement.execute("insert into user(id,username) values (9,'重复数据')");
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }
//        connection.commit();
        System.out.println("=======");
    }

    @Test
    public void saveDataWithTranslationProxy() throws SQLException {
        JdbcServiceImpl jdbcService = new JdbcServiceImpl(statement);

        TransactionProxy transactionProxy = new TransactionProxy(connection, jdbcService);

        JdbcService jdbcServiceProxy = (JdbcService) Proxy.newProxyInstance(jdbcService.getClass().getClassLoader(),
                jdbcService.getClass().getInterfaces(), transactionProxy);

        jdbcServiceProxy.saveDataWithTranslation();
    }

    @AfterAll
    public void destroy() throws SQLException {
        if (null != statement) {
            statement.close();
        }
        if (null != connection) {
            connection.close();
        }
        if (null != dataSource) {
            dataSource.close();
        }
    }
}
