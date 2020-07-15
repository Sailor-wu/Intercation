package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ָ���ַ������ҳ� 
 * ��һ���ַ�(С��ָ���ַ�����)����λ��
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
	    	//ÿ�����ƣ�����ַ�������p��ɢ���У����ټ���
	    	//��ǰɢ��ֵ>= 1��ʾ�ַ�������p��
	        char charAt = s.charAt(right++);
			if (hash[charAt]-- >= 1) {
				count--; 
			}
	        
	        //�������½���0ʱ����ʾ�����ҵ�����ȷ�����գ�
	        //Ȼ����Ӵ��ڵ���ߵ�����б�
	        if (count == 0) {
	        	list.add(left);
	        }
	    
	        //������Ƿ��ִ��ڵĴ�С����p����ô���Ǳ��������ƶ�(��С����)���ҵ��µ�ƥ�䴰��
	        //++������ɢ�У���Ϊ�����߳������
	        //ֻ�����ַ���p�еļ���
	        //����>= 0��ʾ���ڹ�ϣ����ԭʼ�ģ���Ϊ��������0����
	        
	        if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) {
	        	count++;
	        }
	    }
	    return list;
	}
}
