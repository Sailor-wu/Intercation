package com.proxy.cglibproxy;

import com.proxy.IUserService;
import com.proxy.impl.UserServiceImpl;

public class CglibProxyMain {
	public static final int SZ = 20_000_000_00;
	
	public static void main(String[] args) throws Exception {
		IUserService userService = new UserServiceImpl();
		CglibProxy cglibProxy = new CglibProxy();
		IUserService proxy = (IUserService) cglibProxy.getProxy(userService.getClass());
		proxy.add();
	}
}
