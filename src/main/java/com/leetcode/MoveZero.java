package com.leetcode;

/**
 * �ƶ���
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
		// ����ָ��i��j
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			// 01  ��ǰԪ��!=0���Ͱ��佻������ߣ�����0�Ľ������ұ�
//			if(nums[i]!=0) {
//				// ����
//				int tmp = nums[i];
//				nums[i] = nums[j];
//				nums[j++] = tmp;
//			}
			
			if (nums[i] != 0) {
				/* 02 i > j
				 * �����������鿪ͷ�Ƿ���Ԫ�صĽ���Ҳ������ֹ��i==j��ʱ������ 
				 * ��i > j ʱ��ֻ��Ҫ�� i ��ֵ��ֵ��j ����ԭλ�õ�ֵ��0��
				 * ͬʱ����Ҳ�ѽ������������˸�ֵ������ ������һ��������䣬�������ܸ���ʡʱ�䡣
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
