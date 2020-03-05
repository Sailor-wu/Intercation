package com.suanfa4;

import java.util.Scanner;

import org.apache.commons.lang3.builder.StandardToStringStyle;

/**
 * log
 * 
 * @author W.hy
 */
public class Practice1_1_26 {
	
	public static void main(String[] args) {
		runApp();
	}

	private static void runApp() {
		int a= 2,b=9,c=1 ,d = 45,t;

		if (a>b) {
			t= a; a= b; b= t;
		}
		if (a>c) {
			t= a; a = c; c= t;
		}
		if (b>c) {
			t = b; b = c; c = t;
		}
		if (c>d) {
			t = c; c = d; d = t;
		}
		System.out.printf("%d < %d < %d < %d",a,b,c,d);
	}

}
