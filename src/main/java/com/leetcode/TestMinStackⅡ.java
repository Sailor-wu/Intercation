package com.leetcode;

import java.util.concurrent.ThreadLocalRandom;

class MinStack�� {
	int[] array;  // Ԫ������
    int curSize;  // ������ǰ����
    int topIndex; // ��ǰ�����±�
    int minVal;   // ��Сֵ
    int maxVal;   // ���ֵ
    /** ��ʼ�����飬Ĭ�ϸ�4������*/
    public MinStack��() {
        array = new int[4];
        curSize = 4;
        topIndex = -1;
    }
    /**
     * ѹ��ջ
     * @param x
     */
    public void push(int x) {
    	// ���Ϊ��
        if(isEmpty()) {
            minVal = x;// Ĭ�ϵ�һ��Ϊ��Сֵ
            maxVal = x;
        }
        // ���뺯��   ǰ �ж��Ƿ���Ҫ����  
        if(topIndex + 1 < curSize) {
            array[++topIndex] = x;
        } else {
            int[] tmp = new int[2*curSize];
            //������ֵ
            for(int i = 0; i < curSize; i++) {
                tmp[i] = array[i];
            }
            // ����cursize
            curSize = 2*curSize;
            array = tmp; // �����µ�����
            array[++topIndex] = x; // ����ֵ
        }
        // �ж��Ƿ���С
        if(minVal > x) {
            minVal = x;
        }
        // �ж��Ƿ����
        if(maxVal < x) {
        	maxVal = x;
        }
    }
    /**
     * ����ջ
     */
    public void pop() {
    	// ��Ϊ���򵯳�
        if(!isEmpty()) {
        	// �жϵ������Ƿ�����С�ģ�
            if(array[topIndex] == minVal) {
                if(topIndex -1 >=0) {
                    minVal = array[topIndex -1];
                    // ����С����Ҫ�ٴλ�ȡ��С��ֵ���ٴ�ѭ��������С��
                    for(int i = 0; i <=topIndex-1;i++) {
                        if(minVal > array[i]) {
                            minVal = array[i];
                        }
                    }
                }
            }
            // �ж��Ƿ������
            if(array[topIndex] == maxVal) {
                if(topIndex -1 >=0) {
                	maxVal = array[topIndex -1];
                    // ����С����Ҫ�ٴλ�ȡ����ֵ���ٴ�ѭ���������
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

public class TestMinStack��{
	public static void main(String[] args) {
		MinStack�� stack = new MinStack��();
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
