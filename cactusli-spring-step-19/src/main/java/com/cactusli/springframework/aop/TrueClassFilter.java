package com.cactusli.springframework.aop;

/**
 * Created by cactusli on 2023/1/9 15:10
 */
public class TrueClassFilter implements ClassFilter {

    public static final TrueClassFilter INSTANCE = new TrueClassFilter();

    private TrueClassFilter() {
    }


    @Override
    public boolean matches(Class<?> clazz) {
        return true;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override
    public String toString() {
        return "ClassFilter.TRUE";
    }

}
