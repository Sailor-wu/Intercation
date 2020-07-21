package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.pub.link.LinkListStatck;

/**
 * 不同的二叉搜索树Ⅱ
 * @author W.hy
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
示例：
输入：3
输出：
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释：
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 *
 */
public class DiffBinaryTreeⅡ {

	public static void main(String[] args) {
		int n = 3;
		List<TreeNode> nodes =new DiffBinaryTreeⅡ().generateTree(n);
		for (TreeNode treeNode : nodes) {
			System.out.println(treeNode );
		}
	}

	
	private List<TreeNode> generateTree(int n) {
		TreeNode treeNode;
		if(n<=0) { 
			return new ArrayList<TreeNode>();
		} 
		return getTree(1,n);
	}


	private LinkedList<TreeNode> getTree(int start, int end) {
		TreeNode node;
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		// 没有节点了，返回一个空节点
		if(start > end) {
			nodes.add(null);
			return nodes;
		}
		// 只有一个数字，当前数组作为一个树返回
		if (start == end) {
			node = new TreeNode(start);
			nodes.add(node);
			return nodes;
		}
		// 否则尝试每个数字为根节点继续组装树
		for (int i = start; i <= end; i++) {
			// 得到是左边树
			LinkedList<TreeNode> leftTreeNodes = getTree(start, i-1);
			// 得到是右边树
			LinkedList<TreeNode> rightTreeNodes = getTree(i + 1, end);
			// 左右树结合
			for (TreeNode treeNode : leftTreeNodes) {
				for (TreeNode treeNode2 : rightTreeNodes) {
					node = new TreeNode(i);
					// 添加左右
					node.left = treeNode;
					node.right= treeNode2;
					nodes.add(node);
				}
			}
		}
		return nodes;
	}
}
