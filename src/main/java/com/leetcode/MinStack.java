package com.leetcode;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 最小栈
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
		System.out.println("\n最小："+stack.getMin());
		System.out.println("top："+stack.top());
		System.out.println("最大："+stack.getMax());
		for (int i = 0; i < len/2; i++) {			
			stack.pop();
		}
		System.out.println("---------pop---------");
		System.out.println("\n最小："+stack.getMin());
		System.out.println("top："+stack.top());
		System.out.println("最大："+stack.getMax());
	}
	
}

class MStack{
	// 最小链表栈
	LinkedList<Integer> stack;
	// 最小链表栈
	LinkedList<Integer> maxStack;
	// 最小值
    int min = Integer.MAX_VALUE;
    // 最大值
    int max = Integer.MIN_VALUE;
    /**
     * 构造链表
     */
    public MStack() {
        stack = new LinkedList<>();
        maxStack = new LinkedList<Integer>();
    }
    
    /**
     * 保存数据--入栈
     * @param val 值
     */
    public void push(int val) {
    	// 如果入栈 值小于最小值，需要替换 
    	if(val > min) {
    		stack.push(val);
    	} else { 
    		// 栈---先进后出
    		stack.push(min);
    		stack.push(val);
    		min = val;
		}
    	//  如果入栈 值大于最大值，需要替换 
    	if(val < max) {
    		maxStack.push(val);
    	} else { 
    		// 栈---先进后出
    		maxStack.push(min);
    		maxStack.push(val);
    		max = val;
		}
    }
    /**
     * 出栈
     */
    public void pop() {
    	// 如果出栈的数是最小的，需要把出栈的最小替换为次小的
    	// 比如：原来栈： 10 ， 8 ，7    7出栈，要把最小的替换为 8
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
     * 获取栈的第一个数
     * @return
     */
    public int top() {
    	return stack.peek();
    }
    /**
     * 获取最小的值<p>
     * 如果是新建的栈，最小值为Integer.MAX_VALUE.
     * @return
     */
    public  int  getMin() {
    	return min;
    }
    
    
    public  int getMax() {
    	return max;
    }
}
