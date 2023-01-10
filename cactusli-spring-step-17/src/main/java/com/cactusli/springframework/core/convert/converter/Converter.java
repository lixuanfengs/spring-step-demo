package com.cactusli.springframework.core.convert.converter;

/**
 * Created by cactusli on 2022/12/29 14:41
 */
/**
 * A converter converts a source object of type {@code S} to a target of type {@code T}.
 *
 * 类型转换处理接口
 *
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface Converter<S, T> {

    /** Convert the source object of type {@code S} to target type {@code T}. */
    T convert(S source);
}
