package com.leetcode;
/**
 * 交叉查找二叉树最长的路径  和
 * @author W.hy
 *
 */
public class SearchBinaryTreeMax {
	private int result;
	public static void main(String[] args) {
		Integer [] arr = new Integer[] {1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1};//[1,1,1,null,1,null,null,1,1,null,1]
//		Integer [] arr = new Integer[] {1,1,1,null,1,null,null,1,1,null,1};
		TreeNode root = TreeNode.fromArray(arr);
		int zag = new SearchBinaryTreeMax().longestZigZag(root);
		System.out.println("result:"+zag);
	}
    public int longestZigZag(TreeNode root) {
        dfs(root.left, -1, 1);
        dfs(root.right, 1, 1);
        return result;
    }

    private void dfs(TreeNode root, int last, int len) {
        if (null == root) {
            return;
        }
        result = Math.max(result, len);
        if (last == -1) {
            dfs(root.left, -1, 1);
            dfs(root.right, 1, len + 1);
        } else {
            dfs(root.left, -1, len + 1);
            dfs(root.right, 1, 1);
        }
    } 
	
//	static int max_len =0;
//	public static void main(String[] args) {
//		Integer [] arr = new Integer[] {1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1};
//		TreeNode root = TreeNode.fromArray(arr);
//		new SearchBinaryTreeMax().longestZigZag(root);
//		System.out.println("result:"+max_len);
//	}
//	
//	public int longestZigZag(TreeNode root) {
//        solution(root,false,0);
//        solution(root,true,0);
//        return max_len ;
//   }
//
//   public void solution(TreeNode root,boolean isL,int len){
//
//       if(root==null){ 
//           // 退出
//           return;
//       }
//       // 最大长度
//       max_len = Math.max(max_len,len);
//       if(isL){// 交叉
//           solution(root.left,false,1);
//           solution(root.right,true,len+1);
//       }else{
//           solution(root.left,false,len+1);
//           solution(root.right,true,1);
//       }
//
//   }
}
