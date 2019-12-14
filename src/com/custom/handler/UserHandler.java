package com.custom.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("查询用户名");
		return null;
	}

}
