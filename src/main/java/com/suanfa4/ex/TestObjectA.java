package com.suanfa4.ex;

import com.suanfa4.ex.com.SunA;
import com.suanfa4.ex.com.SunB;

/**
 * @author W.hy
 *
 */
public class TestObjectA {

	public static void main(String[] args) {
		SunA a = new SunA();
		SunB b = new SunB();
//		a.setState(1);
//		a.sysText();
//		b.sysText();
		if (ObjectA.getState() <= 0) {
			a.sysText();
		}else {
			b.sysText();
		}
	}
	
}
