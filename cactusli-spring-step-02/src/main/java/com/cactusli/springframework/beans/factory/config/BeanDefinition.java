package com.cactusli.springframework.beans.factory.config;

/**
 * Created by cactusli on 2022/11/30 10:25
 */
public class BeanDefinition {

    public Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }
    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
