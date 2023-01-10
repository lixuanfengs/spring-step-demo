import bean.IUserService;
import com.cactusli.springframework.beans.BeansException;
import com.cactusli.springframework.beans.factory.config.BeanPostProcessor;
import com.cactusli.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cactusli on 2022/11/30 9:48
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApiTest {


    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

}
