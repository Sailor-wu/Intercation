package com.suanfa4;

import java.util.Scanner;

public class Practice1_1_3 {

	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		int arr [] = new int[3];
		int i = 0;
		int input;
		while (i<3) {
			try {
				System.out.print("请输入第 "+(i+1)+"个 值：");
				input = inScanner.nextInt();
				arr[i] = input;
				i++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		boolean flg = false;
		int num1,num2;
		System.out.print("输入的值是：");
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j]+"\t");
			if (j+1 == arr.length) {
				break;
			}
			num1 = arr[j];num2 = arr[j+1];
			if (num1 == num2) {
				flg = true;
			}else {
				flg = false;
			}
		}
		// 是否相等
		System.out.println("是否相等:"+flg);
	}
}
