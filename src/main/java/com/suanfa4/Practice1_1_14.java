package com.suanfa4;


/**
 * log
 * @author W.hy
 */
public class Practice1_1_14 {
	public static void main(String[] args) {
		System.out.println(lg(9));
	}
	
	private static int lg(int num) {
		int  j = 0;
		while (num!=1) {
			num = num / 3;
			j++;
		}
		return j;
	}
}
