package com.suanfa4;

import java.util.concurrent.ConcurrentMap;

import io.netty.util.internal.ThreadLocalRandom;

public class Practice1_1_11 {

	public static void main(String[] args) {
		printFlg();
	}

	private static void printFlg() {
		boolean a [] [] = new boolean[10][10];
		// 初始化 二维数组
//		a = initArr(a);
//		print(a);
	}

	private static void print(boolean[][] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print("行数："+i+" \t");
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}

	private static boolean[][] initArr(boolean[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (ThreadLocalRandom.current().nextBoolean()) {
					a[i][j] = true;
				}else {
					a[i][j] = false;
				}
			}
		}
		return a;
	}
}
