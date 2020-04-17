package com.suanfa4.ex;
/**
 * 父类
 * 有一个共同的计数属性 state
 * @author W.hy
 *
 */
public class ObjectA {

	
	private static int state;

	public static int getState() {
		return state;
	}

	public static  void park() {
		state = 1;
	}
	public static  void unPark() {
		state = 0;
	}
}
