package service;

import com.cactusli.springframework.jdbc.support.JdbcTemplate;

import java.sql.SQLException;

/**
 * Created by cactusli on 2023/1/4 16:32
 */
public interface JdbcService {


    void saveDataWithTranslation() throws SQLException;


    void saveData(JdbcTemplate jdbcTemplate) ;

}
