package com.cactusli.springframework.core.convert.converter;



/**
 * Created by cactusli on 2022/12/29 14:43
 */
/**
 * A factory for "ranged" converters that can convert objects from S to subtypes of R.
 *
 * 类型转换工厂
 *
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface ConverterFactory<S, R> {

    <T extends R> Converter<S, T> getConverter(Class<T> targetType);
}
