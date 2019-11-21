package com.pub.jmh;

public class Counter2 implements Counter {

	private  int  X;
	
	@Override
	public int inc() {
		return X++;
	}

}
