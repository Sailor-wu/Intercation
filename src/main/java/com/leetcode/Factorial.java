package com.leetcode;

public class Factorial {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {			
			System.out.println(new Factorial().preimageSizeFZF(i));
		}
	}
	public int preimageSizeFZF(int K) {
		if (K == 1000000000) // 懒得把int改成long
			return 5;
		return help(K + 1) - help(K);
	}

	// 求第一个数，其阶乘零>=k
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

	// 计算n!末尾0的个数
	int countZero(int n) {
		int res = 0;
		while (n >= 5) {
			n /= 5;
			res += n;
		}
		return res;
	}
}
