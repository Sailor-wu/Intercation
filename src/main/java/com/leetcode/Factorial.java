package com.leetcode;

public class Factorial {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {			
			System.out.println(new Factorial().preimageSizeFZF(i));
		}
	}
	public int preimageSizeFZF(int K) {
		if (K == 1000000000) // ���ð�int�ĳ�long
			return 5;
		return help(K + 1) - help(K);
	}

	// ���һ��������׳���>=k
	int help(int K) {
		int l = 0, r = Integer.MAX_VALUE;
		while (l < r) {
			int m = (l + r) >> 1;
			int cnt = countZero(m);
			if (cnt < K)
				l = m + 1;
			else
				r = m;
		}
		return l;
	}

	// ����n!ĩβ0�ĸ���
	int countZero(int n) {
		int res = 0;
		while (n >= 5) {
			n /= 5;
			res += n;
		}
		return res;
	}
}
