package com.cactusli.springframework.beans.factory;

/**
 * Created by cactusli on 2022/12/1 12:15
 * bean 属性信息
 */
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}
