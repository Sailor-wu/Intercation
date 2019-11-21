package com.pub.jmh;

public class Counter1 implements Counter {

	private  int  X;
	
	@Override
	public int inc() {
		return X++;
	}

}
