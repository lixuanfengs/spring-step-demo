package com.cactusli.springframework.beans.factory.config;

import com.cactusli.springframework.beans.BeansException;

/**
 * Created by cactusli on 2022/11/30 10:25
 *
 * 单例注册表
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
