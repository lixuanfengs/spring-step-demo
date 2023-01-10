package com.cactusli.springframework.beans.factory.support;

import com.cactusli.springframework.beans.BeansException;
import com.cactusli.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * Created by cactusli on 2022/11/30 15:12
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException;
}
