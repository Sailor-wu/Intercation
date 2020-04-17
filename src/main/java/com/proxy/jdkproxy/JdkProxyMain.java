package com.proxy.jdkproxy;

import com.proxy.IUserService;
import com.proxy.impl.UserServiceImpl;

public class JdkProxyMain {

	public static void main(String[] args) throws Exception {
		IUserService  userService = new UserServiceImpl();
		userService.add();
		System.out.println("添加了代理之后....");
		MyInvocationHandler handler = new MyInvocationHandler(userService);
		IUserService proxy = (IUserService) handler.getProxy();
		proxy.add();
	}
}
