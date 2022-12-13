package com.cactusli.springframework.beans.factory.support;

import com.cactusli.springframework.beans.BeansException;
import com.cactusli.springframework.core.io.Resource;
import com.cactusli.springframework.core.io.ResourceLoader;

/**
 * Created by cactusli on 2022/12/2 10:11
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws  BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
