package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	Integer val;
	TreeNode left;
	TreeNode right;
	TreeNode(Integer x) { val = x; }
	TreeNode(){}
	public TreeNode sortedArrayToBST(Integer[] nums) {
        return nums==null?null:buildTree(nums,0,nums.length-1);
    }
	
    public static TreeNode buildTree(Integer[] nums,int l,int r){
        if(l>r){
            return null;
        }
        int m = l + (r-l)/2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums,l,m-1);
        root.right = buildTree(nums,m+1,r);
        return root;
    } 
    
    public static TreeNode createTreeNode(Integer[] input, int index){
        if(index<=input.length){
            Integer value = input[index-1];
            if(value!=null){
                TreeNode t = new TreeNode(value);
                t.left = createTreeNode(input, index*2);
                t.right = createTreeNode(input, index*2+1);
                return t;
            }
        }
        return null;
    }
    
    /**
     * 根据传入的数组，生成树
     * @param tree
     * @return
     */
    public static TreeNode fromArray(Integer[] tree) {
        if (tree.length == 0) return null;
        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for (int i = 1; i < tree.length; i++) {
            TreeNode node = q.peek();
            if (node.left == null) {
                node.left = new TreeNode(tree[i]);
                if (tree[i] != null) q.add(node.left);
            } else if (node.right == null) {
                node.right = new TreeNode(tree[i]);
                if (tree[i] != null) q.add(node.right);
                q.remove();
            }
        }
        return root;
    }
}
