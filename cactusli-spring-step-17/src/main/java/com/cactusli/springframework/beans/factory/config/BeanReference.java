package com.cactusli.springframework.beans.factory.config;

/**
 * Created by cactusli on 2022/12/1 12:15
 * Bean 的引用
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
