package com.cactusli.springframework.util;

/**
 * Created by cactusli on 2022/12/23 15:54
 */
/**
 * Simple strategy interface for resolving a String value.
 * Used by {@link com.cactusli.springframework.beans.factory.config.ConfigurableBeanFactory}.
 * <p>
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface StringValueResolver {

    String resolveStringValue(String strVal);

}
