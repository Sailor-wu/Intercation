package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author W.hy
 *
 */
public class TwoSum {

	public static void main(String[] args) {
//		List<String> list = new TwoSum().twoSum(); 
//		for (String string : list) {
//			System.out.println(string);
//		}
		
//		new TwoSum().generate(0, 6, "");
		//��������
//		new TwoSum().generateK(3,3,"");
		
		// ����֮��  ��
		int [] arr = new TwoSum().sum2_shuangzhizhen();
		System.out.println(arr[0]+"--"+arr[1]);
		
	}

	private int[] sum2_shuangzhizhen() {
		int nums [] = new int[] {0,0,3,4};
		int target =0;
		int [] res = new int[2];  
		int left = 0,right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] == target) {
				res[0] = left+1;
            	res[1] = right+1;
            	break;
			}else if (nums[left] + nums[right] > target) {
				right --;
			}else {
				left++;
			}
		}
		return res;
	}

	private int[] sum2() {
		int nums [] = new int[] {0,0,3,4};
		int target =0;
		int [] res = new int[2]; 
        for(int i = 0; i<nums.length; i++){
            int b = target-nums[i];
            int b_v = find_b(nums,b,i+1);
			if(b_v > -1  && nums[i] <= b) {
            	res[0] = i+1;
            	res[1] = b_v+1;
            	break;
            }

        }
		
		return res;
		 
	}
	/**
	 * ���ֲ��ҷ�,���� b �Ƿ���ڣ����ھͷ����±� ���򷵻�-1
	 * @param arr
	 * @param b
	 * @return b
	 */
	private static int find_b(int[] arr, int b,int left) { 
		int right = arr.length - 1;// ����
		int mid; // �з��м�ֵ
		
		while (left <= right) {
			// �з��±�
			mid = left + (right - left) / 2;
			// �ж��з��±��ֵ �� �Ƚϵ�ֵ
			// ���������� ������Ҫ�ı�  �зֵ� - 1 
			// ��������ұ� ������Ҫ�ı�  �зֵ� + 1
			if(arr[mid] > b) {
				right = mid - 1;
			}else if (arr[mid] < b) {
				left = mid + 1;
			}else if (arr[mid] == b) {
				return mid;
			}
		}
		return -1;
	}
	/**
	 * ����n�����ţ��������Ÿ�һ��
	 * @param left ��
	 * @param right��
	 * @param string �������
	 */
	private void generateK(int left, int right, String string) {
		// ����������Ž���
		if (left == 0 && right == 0) {
			System.out.println(string);
			return;
		}
		
		// �����������
		if (left >0) {			
			generateK(left-1, right, string+"(");
		}
		// �����������֮���������ұߵ�
		if (right > left) {
			generateK(left, right-1, string+")");
		}
	}

	private List<String>  twoSum() {
		List<String> list = new LinkedList<String>();
		int nums [] = new int[] {2, 7,9,2,11,0, 15,3,6};
		int target = 9;
		Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int key = target-nums[i];
			if(m.get(key) != null){
//                return new int[]{m.get(key), i};
				list.add(m.get(key)+"-"+i);
            }else {	// ���ÿ����ֻ�ܼ���һ�Σ���ô�ڱ����ʱ��ֻ�ܱ���һ�Ρ�			
            	m.put(nums[i],i);
			}
        }
        return list;
	}
	
	
	// �ݹ�ģ��
	public void generate(int level,int max,String str) {
		// �ս���
		if (level >= max) {
			
			System.out.println(str);
			return;
		}
		// �����߼�
//		String str1 = str+"(";
//		String str2 = str+")";
		// ��һ��
		generate(level+1, max, str+"(");
		generate(level+1, max, str+")");
		// ����
		
	}
	
	
}
