package com.leetcode;

/**
 * 整数拆分，获取最大的积
 * 
 * @author W.hy 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 
 *         示例 1: 输入: 2 输出: 1 解释: 2 = 1 + 1, 1 × 1 = 1。 
 *         示例 2: 输入: 10 输出: 36 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *         假设 n 不小于 2 且不大于 58。
 */
public class IntSplit {

	public static void main(String[] args) {
//		int n = 19;
//		int res = new IntSplit().integerBreak(n);
//		System.out.println(res);	
		
		
		System.out.println(Math.pow(3,6));
	}
	 public int integerBreak(int n) {
		if(n <= 3) {
			return n - 1;
		}
        int a = n / 3, b = n % 3;
        if(b == 0) {
        	return (int)Math.pow(3, a);
        }
        if(b == 1) {
        	return (int)Math.pow(3, a - 1) * 4;
        }
        return (int)Math.pow(3, a) * 2; 
	 }
}
