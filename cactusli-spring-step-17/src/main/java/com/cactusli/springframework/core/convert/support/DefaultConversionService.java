package com.cactusli.springframework.core.convert.support;

import com.cactusli.springframework.core.convert.converter.ConverterRegistry;

/**
 * Created by cactusli on 2022/12/29 15:03
 */
public class DefaultConversionService extends GenericConversionService {

    public DefaultConversionService() {
        addDefaultConverters(this);
    }

    public static void addDefaultConverters(ConverterRegistry converterRegistry) {
        // 添加各类类型转换工厂
        converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
    }

}
