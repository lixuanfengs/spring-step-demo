package com.cactusli.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.cactusli.springframework.beans.factory.config.BeanDefinition;
import com.cactusli.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by cactusli on 2022/12/22 17:02
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }

}
