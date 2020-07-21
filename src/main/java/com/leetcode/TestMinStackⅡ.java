package com.leetcode;

import java.util.concurrent.ThreadLocalRandom;

class MinStackⅡ {
	int[] array;  // 元素容器
    int curSize;  // 容器当前长度
    int topIndex; // 当前插入下标
    int minVal;   // 最小值
    int maxVal;   // 最大值
    /** 初始化数组，默认给4个长度*/
    public MinStackⅡ() {
        array = new int[4];
        curSize = 4;
        topIndex = -1;
    }
    /**
     * 压入栈
     * @param x
     */
    public void push(int x) {
    	// 如果为空
        if(isEmpty()) {
            minVal = x;// 默认第一个为最小值
            maxVal = x;
        }
        // 加入函数   前 判断是否需要扩容  
        if(topIndex + 1 < curSize) {
            array[++topIndex] = x;
        } else {
            int[] tmp = new int[2*curSize];
            //拷贝数值
            for(int i = 0; i < curSize; i++) {
                tmp[i] = array[i];
            }
            // 更新cursize
            curSize = 2*curSize;
            array = tmp; // 返回新的数组
            array[++topIndex] = x; // 填入值
        }
        // 判断是否最小
        if(minVal > x) {
            minVal = x;
        }
        // 判断是否最大
        if(maxVal < x) {
        	maxVal = x;
        }
    }
    /**
     * 弹出栈
     */
    public void pop() {
    	// 不为空则弹出
        if(!isEmpty()) {
        	// 判断弹出的是否是最小的，
            if(array[topIndex] == minVal) {
                if(topIndex -1 >=0) {
                    minVal = array[topIndex -1];
                    // 是最小的需要再次获取最小的值（再次循环，拿最小）
                    for(int i = 0; i <=topIndex-1;i++) {
                        if(minVal > array[i]) {
                            minVal = array[i];
                        }
                    }
                }
            }
            // 判断是否是最大
            if(array[topIndex] == maxVal) {
                if(topIndex -1 >=0) {
                	maxVal = array[topIndex -1];
                    // 是最小的需要再次获取最大的值（再次循环，拿最大）
                    for(int i = 0; i <=topIndex-1;i++) {
                        if(maxVal < array[i]) {
                        	maxVal = array[i];
                        }
                    }
                }
            }
            topIndex--;
        }
    }
    
    public int top() {
        if(!isEmpty()) {
            return array[topIndex];
        } else {
            return -1;
        }
    }
    
    public int getMin() {
        if(!isEmpty()) {
            return minVal;
        } else {
            return 0;
        }
    }
    
    public int getMax() {
        if(!isEmpty()) {
            return maxVal;
        } else {
            return 0;
        }
    }
    
    public boolean isEmpty() {
        return topIndex == -1? true:false;
    }
}

public class TestMinStackⅡ{
	public static void main(String[] args) {
		MinStackⅡ stack = new MinStackⅡ();
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
