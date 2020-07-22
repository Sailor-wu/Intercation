package com.leetcode;

/**
 * 移动零
 * 
 * @author W.hy
 *
 */
public class MoveZero {

	public static void main(String[] args) {
		int[] nums = new int[] { 0, 0, 2, 23, 0, 0, 4, 22, 0 };
		new MoveZero().moveZeros(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "\t");
		}
	}

	private void moveZeros(int[] nums) {
		if (nums == null) {
			return;
		}
		// 两个指针i和j
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			// 01  当前元素!=0，就把其交换到左边，等于0的交换到右边
//			if(nums[i]!=0) {
//				// 交换
//				int tmp = nums[i];
//				nums[i] = nums[j];
//				nums[j++] = tmp;
//			}
			
			if (nums[i] != 0) {
				/* 02 i > j
				 * 它避免了数组开头是非零元素的交换也就是阻止（i==j）时交换。 
				 * 当i > j 时，只需要把 i 的值赋值给j 并把原位置的值置0。
				 * 同时这里也把交换操作换成了赋值操作， 减少了一条操作语句，理论上能更节省时间。
				 */
				nums[j] = nums[i];
				if (i > j) {
					nums[i] = 0;
				}
				j++;
			}
		}
	}
}
