package com.suanfa4;

/**
 * log
 * 
 * @author W.hy
 */
public class Practice1_1_15 {

	public static void main(String[] args) {

	}

	private static void exFunction1() {
//		String exR1 = exR1(6);
		String exR1 = exR2(6);
		System.out.println(exR1);
	}

	public static String exR2(int n) {
		String s = exR2(n - 3) + n + exR2(n - 2) + n;
		if (n <= 0)
			return "";
		return s;
	}

	public static String exR1(int n) {
		if (n <= 0)
			return "";
		return exR1(n - 3) + n + exR1(n - 2) + n;
	}

	private static void exFunction() {
		int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 1, 1 };
		int arr2[] = histogram(arr1, 25);
		int number = 0;
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
			number += arr2[i];
		}
		System.out.println("\n" + arr1.length);
		System.out.println(number);
	}

	private static int[] histogram(int[] a, int M) {
		int arr2[] = new int[M];
		int n = 0;
		int m = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < a.length; j++) {
				if (i == a[j])
					n++;
				arr2[i] = n;
			}
			n = 0;
		}

		for (int i = 0; i < M; i++) {
			m = m + arr2[i];
		}
		return arr2;
	}
}
