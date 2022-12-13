package com.cactusli.springframework.beans.factory;

import com.cactusli.springframework.beans.BeansException;

/**
 * Created by cactusli on 2022/11/30 10:24
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

}
