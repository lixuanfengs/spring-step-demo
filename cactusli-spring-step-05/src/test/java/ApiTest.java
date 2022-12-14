import bean.UserDao;
import bean.UserService;
import cn.hutool.core.io.IoUtil;
import com.cactusli.springframework.beans.PropertyValue;
import com.cactusli.springframework.beans.PropertyValues;
import com.cactusli.springframework.beans.factory.config.BeanDefinition;
import com.cactusli.springframework.beans.factory.config.BeanReference;
import com.cactusli.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.cactusli.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.cactusli.springframework.core.io.DefaultResourceLoader;
import com.cactusli.springframework.core.io.Resource;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by cactusli on 2022/11/30 9:48
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApiTest {



    private DefaultResourceLoader resourceLoader;

    @BeforeAll
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/main/resources/important.properties");
                InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() {
        // 1.????????? BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. ??????????????????&?????? Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");
       // 3. ?????? Bean ??????????????????
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("???????????????" + result);
    }

    @Test
    public void test_BeanFactory() {
        // 1.????????? BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. UserDao ??????
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        // 3. UserService ????????????[uId???userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        // 4. UserService ?????? bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 5. UserService ?????? bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

    @Test
    public void test_BeanFactory1() {
        // 1.????????? BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. ?????? bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
         // 3.?????? bean
        UserService userService = (UserService) beanFactory.getBean("userService", "?????????");
        userService.queryUserInfo();
    }


    @Test
    public void test_newInstance() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        UserService userService = UserService.class.getDeclaredConstructor().newInstance();
        System.out.println(userService);
    }

    @Test
    public void test_constructor() throws Exception {
        Class<UserService> userServiceClass = UserService.class;
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        UserService userService = declaredConstructor.newInstance("?????????");
        System.out.println(userService);
    }


    @Test
    public void test_parameterTypes() throws Exception {
        Class<UserService> beanClass = UserService.class;
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        Constructor<?> constructor = declaredConstructors[0];
        Constructor<UserService> declaredConstructor = beanClass.getDeclaredConstructor
                (constructor.getParameterTypes());
        UserService userService = declaredConstructor.newInstance("?????????");
        System.out.println(userService);
    }


    @Test
    public void test_cglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object obj = enhancer.create(new Class[]{String.class}, new Object[]{"?????????"});
        System.out.println(obj);
    }

}
