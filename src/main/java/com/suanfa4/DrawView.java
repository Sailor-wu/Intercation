package com.suanfa4;

import java.util.Stack;

import edu.princeton.cs.algs4.StdOut;

public class DrawView {

	public static void main(String[] args) {
//		printChar();
		
		
		// 二进制换十进制
//		binaryToTen();
		
		// 十进制换二进制
//		numberToString();
		
		// 十进制转八进制
//		String string = tenToEight(10);
//		System.out.println(string);
		
		// 十进制转十六进制
//		String  sixteenString = tenToSixteen(15);
//		System.out.println("十进制转十六进制："+sixteenString);
		
		// 万能 的 2  8 16 转10 
//		int almighty = almighty("1000000");
//		System.out.println(almighty);
		
		// 使用栈的方式转换成二进制，栈的特性，先进后出
//		useStack();
		StdOut.print("adsad");
	}
	private static void useStack() {
		Stack<Integer> integers = new Stack<Integer>();
		// 保存二进制
		String tString = "";
		// 原值
		int oldValue = 16;
		while (oldValue != 0) {
			int num = oldValue % 2;
			// 先进
			integers.push(num);
			oldValue = oldValue / 2;
		}
		
		// 取出
		while (!integers.isEmpty()) {
			tString += integers.pop();
		}
		
		System.out.println(tString);
	}
	/**
	 * 	parseInt("0", 10) returns 0    <br/>
		parseInt("473", 10) returns 473<br/>
		parseInt("-0", 10) returns 0<br/>
		parseInt("-FF", 16) returns -255<br/>
		parseInt("1100110", 2) returns 102<br/>
		parseInt("2147483647", 10) returns 2147483647<br/>
		parseInt("-2147483648", 10) returns -2147483648<br/>
		parseInt("2147483648", 10) throws a NumberFormatException<br/>
		parseInt("99", throws a NumberFormatException<br/>
		parseInt("Kona", 10) throws a NumberFormatException<br/>
		parseInt("Kona", 27) returns 411787<br/>
	 * @param string
	 * @return
	 */
	private static int almighty(String string) {
		// string 需要转换的进制值 ;    2  代表原值为2进制
		return Integer.parseInt(string, 2);
	}
	private static String tenToSixteen(int i) {
		return Integer.toHexString(i);
	}
	/**
	 * @param num 十进制数字
	 * @return 八进制
	 */
	private static String tenToEight(int num) {
		return Integer.toOctalString(num);
	}

	private static void binaryToTen() {
		String binary = "1000000";
		int num = Integer.valueOf(binary, 2);
		System.out.println(num);
	}

	private static void numberToString() {
		int  number = 64;
		String string = "";
		for (int i = number; i >0; i /= 2) {
			string = (i % 2 ) + string;
		}
		System.out.println(string);
	}

	private static void printChar() {
		System.out.println('b'+0);
		System.out.println('b'+'c');
		System.out.println('a'+4);
	}
}
