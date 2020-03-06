package com.suanfa4;

public class AssertKMP {
	public static void main(String[] args) {
		// 查找的字符
		String paString = "abcs";
		// 源文本串
		String searchStr = "abcdabcsabg";
		KMP kmp = new KMP(paString);
		// 返回找到的下标
		int search = kmp.search(searchStr);
		System.out.println(search);
		System.out.println(searchStr.substring(search, search+paString.length()));
	}
}
