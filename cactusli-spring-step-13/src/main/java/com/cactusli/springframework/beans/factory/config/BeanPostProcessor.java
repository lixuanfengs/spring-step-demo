package com.cactusli.springframework.beans.factory.config;

import com.cactusli.springframework.beans.BeansException;

/**
 * Created by cactusli on 2022/12/6 11:45
 */
/**
 * Factory hook that allows for custom modification of new bean instances,
 * e.g. checking for marker interfaces or wrapping them with proxies.
 *
 * 用于修改新实例化 Bean 对象的扩展点
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;
}