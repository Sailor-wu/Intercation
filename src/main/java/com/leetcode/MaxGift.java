package com.leetcode;

/**
 * 最大礼物
 * 
 * @author W.hy 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于
 *         0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 *         给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 示例 1:
 * 
 *         输入: [   
 *         		[1,3,1],   
 *         		[1,5,1],   
 *         		[4,2,1] 
 *         ] 输出: 12 
 *         
 *         解释: 路径 1→3→5→2→1
 *         可以拿到最多价值的礼物
 * 
 */
public class MaxGift {

	public static void main(String[] args) {
		int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		// 原地修改
//		int maxValue = new MaxGift().maxValue01(grid);
//		System.out.println(maxValue);
		
		int maxValue = new MaxGift().maxValue(grid);
		System.out.println(maxValue);
	}
	
	private int maxValue(int[][] grid) {
		int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                	continue;
                }
                if(i == 0) {
                	grid[i][j] += grid[i][j - 1] ;
                }else if(j == 0) {
                	grid[i][j] += grid[i - 1][j];
                }else {
                	grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1]; 
	}
	public int maxValue01(int[][] grid) {

		int row = grid.length, 
			col = grid[0].length;
		//第一行元素做前缀和
        for (int i = 1; i < row; ++i)
            grid[i][0] += grid[i - 1][0];
        //第一列元素做前缀和
        for (int j = 1; j < col; ++j)
            grid[0][j] += grid[0][j - 1];
        //剩余元素选择左边和上边元素中较大者做前缀和
        for (int i = 1; i < row; ++i)
            for (int j = 1; j < col; ++j)
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
        //数组矩阵右下角的元素就是最大值，返回它即可
        return grid[row - 1][col - 1]; 
    }
	
	
	
	
}
