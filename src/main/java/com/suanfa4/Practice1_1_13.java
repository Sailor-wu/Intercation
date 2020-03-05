package com.suanfa4;

import io.netty.util.internal.ThreadLocalRandom;

/**
 * 编写一段代码，打印出一一个M行N列的二维数组的转置(交换行和列)。
 * @author W.hy
 */
public class Practice1_1_13 {

	public static void main(String[] args) {
		int m = 5 ,n = 4;
		
		int arr1 [] [] = new int[m][n];
		int arr2 [] [] = new int[n][m];
		// 初始化 arr1
		arr1 = initArr(arr1);
		// 交换行和列
		changeDate(arr1,arr2);
		
	}

	private static void changeDate(int[][] arr1, int[][] arr2) {
		System.out.println("交换：");
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				arr2[j][i] = arr1[i][j];
			}
		}
		
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				System.out.print(arr2[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static int[][] initArr(int[][] arr1) {
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				arr1[i][j] = ThreadLocalRandom.current().nextInt(10);
				System.out.print(arr1[i][j]+" ");
			}
			System.out.println();
		}
		return arr1;
	}
}
