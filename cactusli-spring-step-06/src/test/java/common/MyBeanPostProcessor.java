package common;

import bean.UserService;
import com.cactusli.springframework.beans.BeansException;
import com.cactusli.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by cactusli on 2022/12/7 11:37
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setName("name : 仙人球北京");
            userService.setLocation("Location  改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
