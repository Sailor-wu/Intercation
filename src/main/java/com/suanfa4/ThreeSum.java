package com.suanfa4;

public class ThreeSum {

	public static void main(String[] args) {
		// 需要一个数组
		int arrLength = 100000;
		// 需要一个 和
		int arr [] = new int[arrLength];
		
		int sum = 100000;
		
		// 暴力循环匹配  解决
		forceLoop(arr,sum);
		
	}

	/**
	 * a + b + c = sum;
	 * @param arr
	 * @param sum
	 */
	private static void forceLoop(int[] arr, int sum) {
		// a
		for (int i = 0; i < arr.length; i++) {
			// b
			for (int j = i + 1; j < arr.length; j++) {
				
			}
		}
	}
}
