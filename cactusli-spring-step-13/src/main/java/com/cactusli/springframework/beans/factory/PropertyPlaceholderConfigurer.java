package com.cactusli.springframework.beans.factory;

import com.cactusli.springframework.beans.BeansException;
import com.cactusli.springframework.beans.PropertyValue;
import com.cactusli.springframework.beans.PropertyValues;
import com.cactusli.springframework.beans.factory.config.BeanDefinition;
import com.cactusli.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.cactusli.springframework.core.io.DefaultResourceLoader;
import com.cactusli.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by cactusli on 2022/12/22 16:28
 */
/**
 * Allows for configuration of individual bean property values from a property resource,
 * i.e. a properties file. Useful for custom config files targeted at system
 * administrators that override bean properties configured in the application context.
 * <p>
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {


    /**
     * Default placeholder prefix: {@value}
     */
    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";

    /**
     * Default placeholder suffix: {@value}
     */
    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 加载属性文件
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());

            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);

                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    Object value = propertyValue.getValue();
                    if (!(value instanceof String)) continue;
                    String strVal = (String) value;
                    StringBuilder builder = new StringBuilder(strVal);
                    int starIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
                    int stopIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
                    if (starIdx != -1 && stopIdx != -1 && starIdx < stopIdx) {
                        String propKey = strVal.substring(starIdx + 2, stopIdx);
                        String propVal = properties.getProperty(propKey);
                        builder.replace(starIdx, stopIdx + 1, propVal);
                        propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), builder.toString()));
                    }
                }
            }
        } catch (IOException e) {
            throw new BeansException("Could not load properties", e);
        }
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
