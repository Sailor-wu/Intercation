package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 在指定字符串中找出 
 * 另一个字符(小于指定字符长度)的异位词
 * @author W.hy
 *
 */
public class FindCodeEct {

	public static void main(String[] args) {
		List<Integer> list=new FindCodeEct().find();
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}

	private List<Integer> find() {
		String s="cbaebabacd";
		String p="abc";
		List<Integer> list = new ArrayList<Integer>();
	    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
	    int[] hash = new int[256]; 

	    for (char c : p.toCharArray()) {
	        hash[c]++;
	    }

	    int left = 0, right = 0, count = p.length();
	    while (right < s.length()) {
	    	//每次右移，如果字符存在于p的散列中，减少计数
	    	//当前散列值>= 1表示字符存在于p中
	        char charAt = s.charAt(right++);
			if (hash[charAt]-- >= 1) {
				count--; 
			}
	        
	        //当计数下降到0时，表示我们找到了正确的字谜，
	        //然后添加窗口的左边到结果列表
	        if (count == 0) {
	        	list.add(left);
	        }
	    
	        //如果我们发现窗口的大小等于p，那么我们必须向左移动(缩小窗口)来找到新的匹配窗口
	        //++来重置散列，因为我们踢出了左边
	        //只增加字符在p中的计数
	        //计数>= 0表示它在哈希中是原始的，因为它不会在0下面
	        
	        if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) {
	        	count++;
	        }
	    }
	    return list;
	}
}
