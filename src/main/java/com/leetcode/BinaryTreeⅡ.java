package com.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ��������α�����
 * @author W.hy
 *����һ����������������ڵ�ֵ�Ե����ϵĲ�α����� 
 *��������Ҷ�ӽڵ����ڲ㵽���ڵ����ڵĲ㣬���������ұ�����
���磺
���������� [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
�������Ե����ϵĲ�α���Ϊ�� 
[
  [15,7],
  [9,20],
  [3]
] 
 */
public class BinaryTree�� {

	public static void main(String[] args) {
		// ����������
		Integer [] nums = new Integer[] {3,9,20,null,null,15,7};
		// �������ڵ�
		TreeNode root = TreeNode.fromArray(nums);
		// ����
		List<List<Integer>> levelOrderBottom = new BinaryTree��().levelOrderBottom(root);
		for (List<Integer> list : levelOrderBottom) {
			System.out.println(list);
		}
	}
	// ����
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
            	// �Ӷ����л�ȡͷԪ��
                TreeNode node = q.poll();
                if (node.val!=null) {					
                	tmp.add(node.val);
				}
                // �ڵ㻹�����ӽڵ㣬��������
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            // ������ 0 ��λ�ü���һά���� tmp
            // ÿ���µ�����������ᱻ���ڿ�ʼ��λ��
            ans.add(0, tmp);
        }
        return ans; 
    }
}
