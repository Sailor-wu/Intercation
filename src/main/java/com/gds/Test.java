package com.gds;

import com.gds.utils.DateTimeUtil;

public class Test {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		
		for (int i = 0; i <1000; i++) {
			for (int j = 0; j < 1000; j++) {
				int num = i+j;
			}
		}
		System.out.println(DateTimeUtil.getSystemDiffDataTime(time)+"/ms");
	}
}
