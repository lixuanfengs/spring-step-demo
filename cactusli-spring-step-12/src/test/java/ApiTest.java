import bean.IUserService;
import com.cactusli.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * Created by cactusli on 2022/11/30 9:48
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApiTest {


    @Test
    public void test_aop() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
        System.out.println("测试结果：" + userService.register("程序媛"));
    }

}
