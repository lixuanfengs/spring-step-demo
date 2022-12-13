package com.cactusli.springframework.beans.factory.support;

import com.cactusli.springframework.beans.factory.config.BeanDefinition;

/**
 * Created by cactusli on 2022/11/30 10:26
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
