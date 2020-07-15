package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

import org.apache.commons.math3.geometry.Space;

/**
 * �ִ�  ����δʶ����ַ���
 * @author W.hy
 *
 */
public class ReplaceSpace {

	// ʹ��Trie����ǰ׺�������ֵ�����
	public static void main(String[] args) {
		TrieTree tree = new TrieTree();
		String dictionary[] = {"looked","just","like","her","brother"};
		String sentence = "jesslookedjustliketimherbrother" ;
		TrieTreeCount(tree, dictionary, sentence);
	}

	private static void TrieTreeCount(TrieTree tree, String[] dictionary, String sentence) {
		LinkedList<String> unidentStr = new LinkedList<String>();
		// �����ֵ���
		for (String s : dictionary) {			
			tree.buildTree(s);
		}
		
		int len = sentence.length(),start = 0,end = 0,count = 0;
		int [] dp = new int[len+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		StringBuilder sb = new StringBuilder();
		dp[0] = 0;
		for (int i = 1; i <= len; ++i) {
			dp[i] = dp[i -1]+1;
			TrieTree tree2 = tree;
			sb.append(sentence.charAt(i-1));
			for (int j = i; j >= 1; --j) {
				char cval = sentence.charAt(j-1);
				int t = cval -'a';
				if(tree2.nexTrees[t] == null) {
					break;
				}else if (tree2.nexTrees[t].isEnd) {
					dp[i] = Math.min(dp[i], dp[j-1]);
////					unidentStr.add(sb.toString().substring(0, dp[i]));
//					System.out.println(sb.toString() );
//					int length = sb.length();
//					if (length>= (i-j)) { 
//						System.out.println("i:"+i+" \t  j:"+j +"\t sb:"+sb.toString().substring(0,(i-j -1)));
//					}
////					sb.setLength(0);
				}
				if (dp[i] == 0) {
					break;
				}
				tree2 = tree2.nexTrees[t];
			}
		}
		System.out.println(dp[len]);
	}
}

class TrieTree{
	
	public TrieTree[] nexTrees; //��һ���ڵ���
	public boolean isEnd;// �Ƿ���Ҷ�ڵ�
	
	// Ĭ�Ϲ���
	public TrieTree() {
		nexTrees = new TrieTree[26];
		isEnd = false;
	}
	
	/**
	 * ������ ����ַ��������
	 * @param s
	 */
	public void buildTree(String s) {
		TrieTree cusTree = this;
		int t = 0;
		for (int i =  s.length() -1; i >=0; --i) {
			t = s.charAt(i) -'a';
			if(cusTree.nexTrees[t]==null) {
				cusTree.nexTrees[t] = new TrieTree();
			}
			cusTree = cusTree.nexTrees[t];
		}
		cusTree.isEnd = true;
	}
	
}
