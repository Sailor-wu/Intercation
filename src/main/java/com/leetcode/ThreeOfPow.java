package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.checkerframework.checker.units.qual.m;

import edu.princeton.cs.algs4.In;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * @author W.hy
 *
 */
public class ThreeOfPow {

	public static void main(String[] args) {
		int num = 2147483647;
		boolean flg = new ThreeOfPow().powNum(num);
		System.out.println(flg);
		flg = new ThreeOfPow().isThreePow(num);
		System.out.println(flg);
		
	}

	/**
	 * 
	 * @param num
	 * @return
	 */
	private boolean powNum(int n) {
		HashSet<Integer> set = new HashSet<>(Arrays.asList(1, 3, 9, 27, 
	            81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441,
	            1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467));
	    return set.contains(n);
	}
	
	public boolean isThreePow(int n) {
		int i = 0, d=0;
		HashMap<Integer,Boolean> map = new HashMap<Integer, Boolean>();
		while (i<=(int)(Math.log(Integer.MAX_VALUE) / Math.log(3))) {
			d = (int) Math.pow(3,i);
			System.out.println(d); 
			map.put(d, true);
			++i;
		}
		return map.containsKey(n);
	}
	
}
