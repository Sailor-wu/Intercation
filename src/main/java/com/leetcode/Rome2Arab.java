package com.leetcode;

/**
 * 罗马字符转阿拉伯数字
 * 
 * @author W.hy
 *
 *         Ⅰ 1 Ⅳ 4 Ⅴ 5 罗马数字由 I,V,X,L,C,D,M 构成； 当小值在大值的左边，则减小值，如 IV=5-1=4；
 *         当小值在大值的右边，则加小值，如 VI=5+1=6； 由上可知，右值永远为正，因此最后一位必然为正。
 */
public class Rome2Arab {

	public static void main(String[] args) {
		String s = "ILIVIII";
		int sum = new Rome2Arab().tatolRome2Alab2(s);
		System.out.println("转换后：" + sum);

	}
	
	int[] romanValues = new int[] { 1, 5, 10, 50, 100, 500, 1000 };
	int getRank(char ch) {
		switch (ch) {
		case 'I':
			return 0;
		case 'V':
			return 1;
		case 'X':
			return 2;
		case 'L':
			return 3;
		case 'C':
			return 4;
		case 'D':
			return 5;
		case 'M':
			return 6;
		default:
			return -1;
		}
	}
	public int tatolRome2Alab2(String s) {
		int res = 0;
		int highestRank = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int rank = getRank(s.charAt(i));
			int val = romanValues[rank];
			if (rank < highestRank)
				res -= val;
			else {
				highestRank = rank;
				res += val;
			}
		}
		return res;
	}

	public int tatolRome2Alab(String s) {
		int sum = 0;
		int preNum = getValue(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			int num = getValue(s.charAt(i));
			if (num > preNum) {
				sum -= preNum;
			} else {
				sum += preNum;
			}
			preNum = num;
		}
		sum += preNum;
		return sum;
	}

	private int getValue(char charAt) {
		switch (charAt) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}
}
