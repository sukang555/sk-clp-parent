package com.skse.se.design.structure.proxy.dynamic.jdk.objetct;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sukang
 */
public class UserInvocationHandler implements InvocationHandler{
	
	//被代理的类
	
	private UserService userService;
	

	public UserInvocationHandler(UserService userService) {
		this.userService = userService;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		if ("hello".equals(method.getName())) {
			System.out.println("方法执行前");
			method.invoke(userService, args);
			System.out.println("方法执行后");
		}
		
		
		return null;
	}

}
