package common;

import com.cactusli.springframework.beans.BeansException;
import com.cactusli.springframework.beans.PropertyValue;
import com.cactusli.springframework.beans.PropertyValues;
import com.cactusli.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.cactusli.springframework.beans.factory.config.BeanDefinition;
import com.cactusli.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * Created by cactusli on 2022/12/7 11:32
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company"," company改为：仙人球1"));
    }
}
