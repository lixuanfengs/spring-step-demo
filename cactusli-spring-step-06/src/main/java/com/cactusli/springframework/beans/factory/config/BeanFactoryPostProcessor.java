package com.cactusli.springframework.beans.factory.config;

/**
 * Created by cactusli on 2022/12/6 11:34
 */

import com.cactusli.springframework.beans.BeansException;
import com.cactusli.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * Allows for custom modification of an application context's bean definitions,
 * adapting the bean property values of the context's underlying bean factory.
 *
 * 允许自定义修改 BeanDefinition 属性信息
 *
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;


}
