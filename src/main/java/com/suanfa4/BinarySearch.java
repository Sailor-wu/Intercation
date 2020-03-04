package com.suanfa4;

import java.util.Arrays;

public class BinarySearch {
	
	/**
	  *  二叉查找法
	 * @param a
	 * @param key
	 * @return
	 */
	public static int rank(int[] a, int key) {
		// 最小
		int lo = 0;
		// 最大
		int hi = a.length - 1;
		while (lo <= hi) { // 被查找的键要么不存在，要么必然存在于a[1o..hi]之中
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}
	public static void main(String[] args) {
	int[] whitelist = {123,2,23,4,5,3,325,33};// In. readInts (args [0]);
	
//	Arrays.sort (whitelist);
//	System.out.println(rank(whitelist, 28));
	
//	System.out.println(Math.abs((-2147483648)));
	double x = Math.pow(2, 31);
	System.out.println((int)x);
	System.out.println(Math.abs(-((int)x)));
	System.out.println(Double.POSITIVE_INFINITY);
	System.out.println(Double.NEGATIVE_INFINITY);
	
	System.out.println(3 <3.1);
	System.out.println(-1.0/0.0);
	
	// 110
	System.out.println(10|6);
	
	System.out.println(10^2);
	
	System.out.println(true&&false || true&&true);
	System.out.println(2.0e-6 * 100000000.1);
	System.out.println((1+2.236)/2);
//	while (!StdIn.isEmpty())
//	{ // 读取键值，如果不存在于白名单中则将其打印
//	int key = StdIn. readInt() ;
//	if (rank(key, whitelist) < 0)
//	StdOut . println(key);
//	}
	}
	
	public static int addNum(int a,int b) {
		return a+b;
	}

//	public static int prevNum() {
//		
//	}
}
