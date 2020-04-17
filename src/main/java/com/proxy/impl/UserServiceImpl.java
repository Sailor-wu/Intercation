package com.proxy.impl;

import com.proxy.IUserService;

public class UserServiceImpl implements IUserService {

	@Override
	public void add() throws Exception {
		System.out.println("====execute   add  method ====");
	}

}
