package com.exception.function;


/**
 * @Author: sukang
 * @Date: 2021/12/13 10:34
 */
@FunctionalInterface
public interface ThrowStringExceptionFunction {

    void throwException(String format, Object... args);
}
