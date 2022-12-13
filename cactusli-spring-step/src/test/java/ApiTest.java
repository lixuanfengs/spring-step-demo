import bean.UserService;
import com.cactusli.springframework.BeanDefinition;
import com.cactusli.springframework.BeanFactory;
import org.junit.jupiter.api.Test;

/**
 * Created by cactusli on 2022/11/30 9:48
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {

        // 1.初始化 beanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注入 bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
