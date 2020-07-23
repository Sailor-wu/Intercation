package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小路径和
 * 
 * @author W.hy 此题是典型的动态规划题目。 
 * 状态定义: 。设dp为大小m X n矩阵，中dp[i][i] 的值代表直到走到(i, j)的最小路径和。 
 * 转移方程: 题目要求，只能向右或向下走，换句话说,当前单元格(i, j)只能从左方元格(i- 1,j) 或上坊单元格 (i,j一1)到,
 * 因此只需要考虑矩阵左边界和上边界。 
 * 走到当前单元格(i, j)的最小路径和=“从左方单元格(i-1,j)与从上方单元格(i,j - 1)来的两个最小路 径和中较小的”+当前单元格值grid[i][j]。
 * 具体分为以下4种情况:
 *         1.当左边和上边都不是矩阵边界时:即当i ≠0,j≠0时，dp[i][j]= min(dp[i一1][j], dp[i][j - 1])+ grid[j][i]; 
 *         2.当只有左边是矩阵边界时:只能从上面来，即当i= 0,j≠0时，dp[i][j]= dp[i][j- 1] + grid[i][j]; 
 *         3.当只有上边是矩阵边界时:只能从左面来,即当i≠0,j= 0时，dp[i][j]= dp[i - 1][j] + grid[i[j]; 
 *         4.当左边和上边都是矩阵边界时:即当i= 0,j= 0时，其实就是起点，dp[i][j]= grid[i][j]; 
 *         初始状态: 。dp初始化即啊，不需要修改初始0值。 ●返回值: 。返回dp矩阵右下角值，即走到终点的最小路径和。
 */
public class MinPathSum {
	static Map<Integer, String> pathMap = new HashMap<Integer, String>();
	public static void main(String[] args) {
		int [][] grid = new int[][] {{1,2,1},{2,3,1},{5,3,5}};
		int result = new MinPathSum().solution(grid);
		
		System.out.println(result);
	}

	/**
	 * 在原矩阵上直接修改
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
				// 开始点 4.当左边和上边都是矩阵边界时:即当i= 0,j= 0时，其实就是起点，dp[i][j]= grid[i][j]; 
				if (i==0&&j==0) {
					continue;//继续
				}
				// 当只有左边是矩阵边界时:只能从上面来，即当i= 0,j≠0时，dp[i][j]= dp[i][j- 1] + grid[i][j];
				// 
				if (i == 0) {
					grid[i][j] = grid[i][j-1]+grid[i][j];
				}
				// 当只有上边是矩阵边界时:只能从左面来,即当i≠0,j= 0时，dp[i][j]= dp[i - 1][j] + grid[i[j]; 
				if (j==0) {
					grid[i][j] = grid[i-1][j]+grid[i][j];
				}
				// 当左边和上边都不是矩阵边界时: 选择从左边和上边来的最小的一边来计算 
				//即当i ≠0,j≠0时，dp[i][j]= min(dp[i一1][j], dp[i][j - 1])+ grid[j][i]; 
				if (i!=0&&j!=0) {
					grid[i][j]= Math.min(grid[i-1][j], grid[i][j-1])+grid[i][j];
				}
			}
		}
		return grid[ilen-1][jlen-1];
	}
	
}
