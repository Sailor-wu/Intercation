package com.suanfa4;

public class KMP {

	private int[][] dp;
	private String part;

	/**
	 * 用 pat 表示模式串，长度为 M，txt 表示文本串，长度为 N。<br/>
	 * KMP 算法是在 txt 中查找子串<br/>
	 * pat，如果存在，返回这个子串的起始索引，否则返回 -1<br/>
	 * 
	 * @param part
	 */
	public KMP(String part) {
		this.part = part;
		int m = part.length();

		// dp[状态][字符] = 下个状态
		// 由于中文的 Ascii 码不确定。这里给了比较大（256*256）
		dp = new int[m][256*256];
		dp[0][part.charAt(0)] = 1;

		int x = 0;

		// 构建状态转移图
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < 256; j++) {
				dp[i][j] = dp[x][j];
			}
			dp[i][part.charAt(i)] = i + 1;
			// 更新
			x = dp[x][part.charAt(i)];
		}
	}

	public int search(String text) {
		int M = part.length();
		int N = text.length();
		int j = 0;
		for (int i = 0; i < N; i++) {
			// 计算下一个状态
			j = dp[j][text.charAt(i)];
			// 到达终止态，返回结果
			if (j == M) {
				return i - M + 1;
			}
		}
		return -1;
	}
	
	
	
	
}
