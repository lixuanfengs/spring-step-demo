package com.cactusli.springframework.beans.factory.support;

import com.cactusli.springframework.beans.BeansException;
import com.cactusli.springframework.core.io.Resource;
import com.cactusli.springframework.core.io.ResourceLoader;

/**
 * Created by cactusli on 2022/12/2 10:11
 */
/**
 * Simple interface for bean definition readers.
 *
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws  BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;
}
