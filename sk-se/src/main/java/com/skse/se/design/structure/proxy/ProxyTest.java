package com.skse.se.design.structure.proxy;

import com.skse.se.design.structure.proxy.dynamic.jdk.UserMapper;
import com.skse.se.design.structure.proxy.dynamic.jdk.UserMapperInvocationHandler;
import com.skse.se.design.structure.proxy.dynamic.jdk.objetct.UserInvocationHandler;
import com.skse.se.design.structure.proxy.dynamic.jdk.objetct.UserService;
import com.skse.se.design.structure.proxy.dynamic.jdk.objetct.UserServiceImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @Author: sukang
 * @Date: 2021/1/27 10:45
 */
public class ProxyTest {


    @Test
    public void dynamicInterfaceTest(){
        UserMapper proxyInstance = (UserMapper)Proxy.newProxyInstance(UserMapper.class.getClassLoader(),
                new Class[]{UserMapper.class},
                new UserMapperInvocationHandler()
        );

        Object selectById = proxyInstance.selectById();

        System.out.println(selectById);
    }


    @Test
    public void dynamicTest(){
        /*
        ClassLoader loader,   目标对象使用的类加载器
        Class<?>[] interfaces, 目标对象实现的接口的类型,使用泛型方式确认类型
        InvocationHandler h  指定动态处理器，执行目标对象的方法时,会触发事件处理器的方法
         */
        UserService proxyInstance = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(),
                new Class[]{UserService.class},
                new UserInvocationHandler(new UserServiceImpl()));

        proxyInstance.hello();
    }
}
