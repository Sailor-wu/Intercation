package com.leetcode;
/**
 * 旋转最小数字
 * @author W.hy
 *把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 *例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，
 *该数组的最小值为1。  
	示例 1：
	
	输入：[3,4,5,1,2]
	输出：1
	示例 2：
	
	输入：[2,2,2,0,1]
	输出：0 
 */
public class RotateMinNum {

	public static void main(String[] args) {
		int [] numbers = new int[] {5,1,3};
		System.out.println(new RotateMinNum().rotate(numbers));
 
	}

	private int rotate2(int[] numbers) {
		int left = 0,right = numbers.length - 1;
		// 二分
		while (left < right) {
			// 二分中点
			int m = (left+right)/2;
			//
			if (numbers[m] > numbers[right]) {
				left = m+1;// 区间在中点的右边 加一开始
			}else if (numbers[m] < numbers[right]) {
				right = m;// 区间在中点的左边 最右边给中点值
			}else {
				right--;
			}
		}
		return numbers[left];
	}

	private int   rotate(int [] numbers) {
		// 
		int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
	}
}
