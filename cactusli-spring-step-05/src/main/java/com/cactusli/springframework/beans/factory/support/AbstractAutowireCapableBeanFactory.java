package com.cactusli.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.cactusli.springframework.beans.BeansException;
import com.cactusli.springframework.beans.PropertyValue;
import com.cactusli.springframework.beans.PropertyValues;
import com.cactusli.springframework.beans.factory.config.BeanDefinition;
import com.cactusli.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * Created by cactusli on 2022/11/30 10:26
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    //private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanName ,beanDefinition , args);
            // 给 Bean 填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor constructor1: declaredConstructors) {
            if (null != args && constructor1.getParameterTypes().length == args.length) {
                constructorToUse = constructor1;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * Bean 属性填充
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {

        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    // A 依赖 B, 获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }

                //属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }

    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
