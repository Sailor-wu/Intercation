package com.leetcode;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ��Сջ
 * @author W.hy
 *
 */
public class MinStack {

	public static void main(String[] args) {
		MStack stack = new MStack();
		int len = 50;
 		for (int i = 0; i < len; i++) {
			int val = ThreadLocalRandom.current().nextInt(1000);
			System.out.print(val+"\t");
			if ( (i+1)%10==0) {
				System.out.println();
			}
			stack.push(val);
		}
		System.out.println("\n��С��"+stack.getMin());
		System.out.println("top��"+stack.top());
		System.out.println("���"+stack.getMax());
		for (int i = 0; i < len/2; i++) {			
			stack.pop();
		}
		System.out.println("---------pop---------");
		System.out.println("\n��С��"+stack.getMin());
		System.out.println("top��"+stack.top());
		System.out.println("���"+stack.getMax());
	}
	
}

class MStack{
	// ��С����ջ
	LinkedList<Integer> stack;
	// ��С����ջ
	LinkedList<Integer> maxStack;
	// ��Сֵ
    int min = Integer.MAX_VALUE;
    // ���ֵ
    int max = Integer.MIN_VALUE;
    /**
     * ��������
     */
    public MStack() {
        stack = new LinkedList<>();
        maxStack = new LinkedList<Integer>();
    }
    
    /**
     * ��������--��ջ
     * @param val ֵ
     */
    public void push(int val) {
    	// �����ջ ֵС����Сֵ����Ҫ�滻 
    	if(val > min) {
    		stack.push(val);
    	} else { 
    		// ջ---�Ƚ����
    		stack.push(min);
    		stack.push(val);
    		min = val;
		}
    	//  �����ջ ֵ�������ֵ����Ҫ�滻 
    	if(val < max) {
    		maxStack.push(val);
    	} else { 
    		// ջ---�Ƚ����
    		maxStack.push(min);
    		maxStack.push(val);
    		max = val;
		}
    }
    /**
     * ��ջ
     */
    public void pop() {
    	// �����ջ��������С�ģ���Ҫ�ѳ�ջ����С�滻Ϊ��С��
    	// ���磺ԭ��ջ�� 10 �� 8 ��7    7��ջ��Ҫ����С���滻Ϊ 8
    	if (stack.peek() > min) {
			stack.poll();
		}else {
			stack.poll();
			min = stack.poll();
		}
    	if (maxStack.peek() < max) {
    		maxStack.poll();
		}else {
			maxStack.poll();
			max = maxStack.poll();
		}
    }
    
    /**
     * ��ȡջ�ĵ�һ����
     * @return
     */
    public int top() {
    	return stack.peek();
    }
    /**
     * ��ȡ��С��ֵ<p>
     * ������½���ջ����СֵΪInteger.MAX_VALUE.
     * @return
     */
    public  int  getMin() {
    	return min;
    }
    
    
    public  int getMax() {
    	return max;
    }
}
