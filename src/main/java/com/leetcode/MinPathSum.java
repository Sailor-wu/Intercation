package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ��С·����
 * 
 * @author W.hy �����ǵ��͵Ķ�̬�滮��Ŀ�� 
 * ״̬����: ����dpΪ��Сm X n������dp[i][i] ��ֵ����ֱ���ߵ�(i, j)����С·���͡� 
 * ת�Ʒ���: ��ĿҪ��ֻ�����һ������ߣ����仰˵,��ǰ��Ԫ��(i, j)ֻ�ܴ���Ԫ��(i- 1,j) ���Ϸ���Ԫ�� (i,jһ1)��,
 * ���ֻ��Ҫ���Ǿ�����߽���ϱ߽硣 
 * �ߵ���ǰ��Ԫ��(i, j)����С·����=�����󷽵�Ԫ��(i-1,j)����Ϸ���Ԫ��(i,j - 1)����������С· �����н�С�ġ�+��ǰ��Ԫ��ֵgrid[i][j]��
 * �����Ϊ����4�����:
 *         1.����ߺ��ϱ߶����Ǿ���߽�ʱ:����i ��0,j��0ʱ��dp[i][j]= min(dp[iһ1][j], dp[i][j - 1])+ grid[j][i]; 
 *         2.��ֻ������Ǿ���߽�ʱ:ֻ�ܴ�������������i= 0,j��0ʱ��dp[i][j]= dp[i][j- 1] + grid[i][j]; 
 *         3.��ֻ���ϱ��Ǿ���߽�ʱ:ֻ�ܴ�������,����i��0,j= 0ʱ��dp[i][j]= dp[i - 1][j] + grid[i[j]; 
 *         4.����ߺ��ϱ߶��Ǿ���߽�ʱ:����i= 0,j= 0ʱ����ʵ������㣬dp[i][j]= grid[i][j]; 
 *         ��ʼ״̬: ��dp��ʼ������������Ҫ�޸ĳ�ʼ0ֵ�� �񷵻�ֵ: ������dp�������½�ֵ�����ߵ��յ����С·���͡�
 */
public class MinPathSum {
	static Map<Integer, String> pathMap = new HashMap<Integer, String>();
	public static void main(String[] args) {
		int [][] grid = new int[][] {{1,2,1},{2,3,1},{5,3,5}};
		int result = new MinPathSum().solution(grid);
		
		System.out.println(result);
	}

	/**
	 * ��ԭ������ֱ���޸�
	 * @param grid
	 * @return
	 */
	private int solution(int[][] grid) {
		if(grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		
		int ilen = grid.length;
		int jlen = grid[0].length;
		for (int i = 0; i < ilen; i++) {
			for (int j = 0; j < jlen; j++) {
				// ��ʼ�� 4.����ߺ��ϱ߶��Ǿ���߽�ʱ:����i= 0,j= 0ʱ����ʵ������㣬dp[i][j]= grid[i][j]; 
				if (i==0&&j==0) {
					continue;//����
				}
				// ��ֻ������Ǿ���߽�ʱ:ֻ�ܴ�������������i= 0,j��0ʱ��dp[i][j]= dp[i][j- 1] + grid[i][j];
				// 
				if (i == 0) {
					grid[i][j] = grid[i][j-1]+grid[i][j];
				}
				// ��ֻ���ϱ��Ǿ���߽�ʱ:ֻ�ܴ�������,����i��0,j= 0ʱ��dp[i][j]= dp[i - 1][j] + grid[i[j]; 
				if (j==0) {
					grid[i][j] = grid[i-1][j]+grid[i][j];
				}
				// ����ߺ��ϱ߶����Ǿ���߽�ʱ: ѡ�����ߺ��ϱ�������С��һ�������� 
				//����i ��0,j��0ʱ��dp[i][j]= min(dp[iһ1][j], dp[i][j - 1])+ grid[j][i]; 
				if (i!=0&&j!=0) {
					grid[i][j]= Math.min(grid[i-1][j], grid[i][j-1])+grid[i][j];
				}
			}
		}
		return grid[ilen-1][jlen-1];
	}
	
}
