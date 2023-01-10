package com.cactusli.springframework.beans.factory;


import com.cactusli.springframework.beans.BeansException;

/**
 * Created by cactusli on 2022/12/27 11:02
 */
/**
 * Defines a factory which can return an Object instance
 * (possibly shared or independent) when invoked.
 *
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface ObjectFactory<T> {

    T getObject() throws BeansException;

}
