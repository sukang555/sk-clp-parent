package com.skse.se.design.structure.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: sukang
 * @Date: 2023/2/27 10:36
 * @Description:
 */
public class UserMapperInvocationHandler implements InvocationHandler {



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return "通过sql操作数据库";
    }
}
