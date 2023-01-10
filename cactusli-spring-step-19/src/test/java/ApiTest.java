

import com.alibaba.druid.pool.DruidDataSource;
import com.cactusli.springframework.aop.AdvisedSupport;
import com.cactusli.springframework.aop.TargetSource;
import com.cactusli.springframework.aop.framework.Cglib2AopProxy;
import com.cactusli.springframework.context.support.ClassPathXmlApplicationContext;
import com.cactusli.springframework.jdbc.datasource.DataSourceTransactionManager;
import com.cactusli.springframework.jdbc.support.JdbcTemplate;
import com.cactusli.springframework.tx.transaction.annotation.AnnotationTransactionAttributeSource;
import com.cactusli.springframework.tx.transaction.interceptor.BeanFactoryTransactionAttributeSourceAdvisor;
import com.cactusli.springframework.tx.transaction.interceptor.TransactionAttribute;
import com.cactusli.springframework.tx.transaction.interceptor.TransactionInterceptor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import service.JdbcService;
import service.impl.JdbcServiceImpl;

import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * Created by cactusli on 2022/11/30 9:48
 */
/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApiTest {

    private JdbcTemplate jdbcTemplate;

    private DataSource dataSource;



    @BeforeAll
    public void init() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        dataSource = applicationContext.getBean(DruidDataSource.class);

 //        jdbcService = applicationContext.getBean(JdbcServiceImpl.class);
    }


    @Test
    public void matchTransactionAnnotationTest() {
        JdbcService jdbcService = new JdbcServiceImpl();
        AnnotationTransactionAttributeSource transactionAttributeSource = new AnnotationTransactionAttributeSource();
        Method[] methods = jdbcService.getClass().getMethods();
        Method targetMethod = null;
        for (Method method : methods) {
            if (method.getName().equals("saveData")) {
                targetMethod = method;
                break;
            }
        }
        TransactionAttribute transactionAttribute = transactionAttributeSource.getTransactionAttribute(targetMethod, jdbcService.getClass());
        System.out.println(transactionAttribute.getName());
    }

    @Test
    public void jdbcWithTransaction() {

        JdbcService jdbcService = new JdbcServiceImpl();

        AnnotationTransactionAttributeSource transactionAttributeSource = new AnnotationTransactionAttributeSource();
        transactionAttributeSource.findTransactionAttribute(jdbcService.getClass());


        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        TransactionInterceptor interceptor = new TransactionInterceptor(transactionManager, transactionAttributeSource);

        BeanFactoryTransactionAttributeSourceAdvisor btas = new BeanFactoryTransactionAttributeSourceAdvisor();
        btas.setAdvice(interceptor);


        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(jdbcService));
        advisedSupport.setMethodInterceptor(interceptor);
        advisedSupport.setMethodMatcher(btas.getPointcut().getMethodMatcher());
        advisedSupport.setProxyTargetClass(false);

        JdbcService proxyCglib = (JdbcServiceImpl) new Cglib2AopProxy(advisedSupport).getProxy();


        proxyCglib.saveData(jdbcTemplate);
    }

}