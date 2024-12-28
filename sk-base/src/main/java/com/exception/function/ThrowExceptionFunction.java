package com.exception.function;

import com.exception.IExceptionMsgDetail;

/**
 * @Author: sukang
 * @Date: 2021/12/13 10:34
 */
@FunctionalInterface
public interface ThrowExceptionFunction {

    void throwException(IExceptionMsgDetail errorMsgDetail, Object... args);
}
