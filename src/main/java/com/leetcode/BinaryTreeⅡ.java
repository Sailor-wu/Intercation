package com.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树层次遍历Ⅱ
 * @author W.hy
 *给定一个二叉树，返回其节点值自底向上的层次遍历。 
 *（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为： 
[
  [15,7],
  [9,20],
  [3]
] 
 */
public class BinaryTreeⅡ {

	public static void main(String[] args) {
		// 给定的数组
		Integer [] nums = new Integer[] {3,9,20,null,null,15,7};
		// 创建树节点
		TreeNode root = TreeNode.fromArray(nums);
		// 处理
		List<List<Integer>> levelOrderBottom = new BinaryTreeⅡ().levelOrderBottom(root);
		for (List<Integer> list : levelOrderBottom) {
			System.out.println(list);
		}
	}
	// 处理
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> tmp = new LinkedList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
            	// 从队列中获取头元素
                TreeNode node = q.poll();
                if (node.val!=null) {					
                	tmp.add(node.val);
				}
                // 节点还存在子节点，添加入队列
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            // 在索引 0 的位置加入一维数组 tmp
            // 每次新的数组进来都会被放在开始的位置
            ans.add(0, tmp);
        }
        return ans; 
    }
}
