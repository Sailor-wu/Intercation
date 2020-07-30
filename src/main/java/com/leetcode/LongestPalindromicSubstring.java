package com.leetcode;

import java.util.HashMap;

/**
 * 
 * @author W.hy 
 * 	   给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *         在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *         注意: 假设字符串的长度不会超过 1010。
 *         示例 1:
 *         输入: "abccccdd"
 *         输出: 7
 *         解释: 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *         
 *   从中间向两边延申
 *   			a
 *   		   cac
 *      	  ccacc
 *      	 dccaccd
 *      
 */
public class LongestPalindromicSubstring {
	 
	public static void main(String[] args) {
		System.out.println(5&1);
		String string = "abcdefghgfecbazAZz";
		int longestPalindrome = new LongestPalindromicSubstring().longestPalindrome(string);
		System.out.println();
		System.out.println(longestPalindrome);
	}
	private int longestPalindrome(String s) {
		int[] count = new int[128];
//		char[] charArray = s.toCharArray();
//		for (int i = 0; i < charArray.length; i++) {
//			System.out.println((int)charArray[i]);
//		}
		// 给对应字母的下标赋值  出现的个数
	      for(char m:s.toCharArray()){
	         count[m]++;
	      }
	      // 返回结果数
	      int ans = 0;
	      for(int v:count){
	    	  // 如果出现次数为0 继续
	          if (v== 0) {
				continue;
			  }
	    	  ans += (v/2)*2;
	    	  System.out.print(v+"-"+(v/2)*2+"= "+ans+"\t");
	    	  // 出现一次的。只放一个
	          if(ans % 2 == 0 && v % 2 == 1) {
	        	  ans++;
	          }
	      }
	      return ans;
	}
	public int longestPalindrome1(String s) {
		int n = s.length();
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int res = 0;
		for (Character key : map.keySet()) {
			Integer val = map.get(key);
			if ((val & 1) == 1)
				res += val - 1;
			else
				res += val;
		}
		if (res < n)
			return res + 1;
		else
			return res;
	}

}
