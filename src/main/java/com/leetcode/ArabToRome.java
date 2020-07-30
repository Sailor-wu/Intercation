package com.leetcode;
/**
 * ����������ת��������
 * @author W.hy
 * ̰���㷨
 */
public class ArabToRome {

	public static void main(String[] args) {
		int num = 1999;
		String str = new ArabToRome().solution(num);
		System.out.println(str);
		str = new ArabToRome().solution2(num);
		System.out.println(str);
	}

	private String solution(int num ) {
		StringBuilder sb = new StringBuilder();
		// �Ѷ�Ӧ���������ֺͶ�Ӧ��ֵ���г���  ˳��һ��Ҫ�Ӵ�С
		int [] values = new int[] {1000, 900, 500, 400, 100, 90, 50,  40, 10,  9,   5,  4,   1};
		String [] romeStr={         "M", "CM", "D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		// 
		for (int i = 0; i < values.length && num > 0; i++) {
			//���ִ��ڵ��� Ŀ�꣬����ѭ��
			while (values[i]<= num) {
				// ���ּ�ȥĿ��
				num-=values[i];
				sb.append(romeStr[i]);
			}
		}
		return sb.toString();
	}
	/**
	 * ȡ�෨
	 * @param num
	 * @return
	 */
	public String solution2(int num) {
		String[] thousands = {"", "M", "MM", "MMM"};
	    String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; 
	    String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	    String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	    return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10]; 
	}
}
