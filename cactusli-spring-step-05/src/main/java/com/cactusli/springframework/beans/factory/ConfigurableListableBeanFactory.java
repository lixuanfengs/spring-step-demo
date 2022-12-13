package com.cactusli.springframework.beans.factory;
import com.cactusli.springframework.beans.BeansException;
import com.cactusli.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.cactusli.springframework.beans.factory.config.BeanDefinition;
import com.cactusli.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * Created by cactusli on 2022/12/2 16:57
 */
/**
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
