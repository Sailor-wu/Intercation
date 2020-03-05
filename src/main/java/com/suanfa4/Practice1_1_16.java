package com.suanfa4;

/**
 * log
 * 
 * @author W.hy
 */
public class Practice1_1_16 {
	public static void main(String[] args) {
		// 直接暴力循环获取最终结果
		int exFun = exFun(4);
		System.out.println(exFun);

		// 使用空间换时间
		int exFun1 = exFun1(4);
		System.out.println(exFun1);
	}
	
	private static int exFun(int num) {
		if (num == 1 || num == 2) {
			return 1;
		}
		return exFun(num-1) + exFun(num - 2);
	}
	
	private static int exFun1(int num) {
		int [] arr = new int [num +1];
		return helper(arr,num);
	}

	private static int helper(int[] arr, int num) {
		if (num == 1 || num == 2) {
			return 1;
		}
		if (arr[num] != 0) {
			return arr[num];
		}
		arr[num] = helper(arr,num-1)+ helper(arr, num -2);
		return arr[num];
	}
}
