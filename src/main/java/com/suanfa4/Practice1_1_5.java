package com.suanfa4;

import java.util.Scanner;

public class Practice1_1_5 {

	public static void main(String[] args) {
		// 两个double
//		towDouble();
		
		// 递加
		printSomeThing();
		
	}

	/**
	 * 递加
	 * 1 + 1 = 2<BR/>
	 * 2 + 1 = 3<BR/>
	 * 3 + 2 = 5<BR/>
	 * 5 + 3 = 8<BR/>
	 * 8 + 5 = 13
	 */
	private static void printSomeThing() {
		int f=0, g=1;
		for (int i = 0; i < 15; i++) {
			System.err.println(f);
			f = f + g;
			g = f - g;
		}
	}

	private static void towDouble() {
		double number1,number2;
		Scanner inScanner = new Scanner(System.in);
		System.out.println("请输入两个 double 类型的数据：");
		number1 = inScanner.nextDouble();
		number2 = inScanner.nextDouble();
		if( (number1>0 && number1 < 1) && (number2>0 && number2 < 1)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
}
