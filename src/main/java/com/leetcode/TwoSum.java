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
		//生成括号
//		new TwoSum().generateK(3,3,"");
		
		// 两数之和  Ⅱ
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
	 * 二分查找法,查找 b 是否存在，存在就返回下标 否则返回-1
	 * @param arr
	 * @param b
	 * @return b
	 */
	private static int find_b(int[] arr, int b,int left) { 
		int right = arr.length - 1;// 最右
		int mid; // 切分中间值
		
		while (left <= right) {
			// 切分下标
			mid = left + (right - left) / 2;
			// 判断切分下标的值 和 比较的值
			// 如果是在左边 最右需要改变  切分点 - 1 
			// 如果是在右边 最左需要改变  切分点 + 1
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
	 * 生成n对括号，左右括号各一个
	 * @param left 左
	 * @param right右
	 * @param string 最后生成
	 */
	private void generateK(int left, int right, String string) {
		// 左右生成完才结束
		if (left == 0 && right == 0) {
			System.out.println(string);
			return;
		}
		
		// 生成左边括号
		if (left >0) {			
			generateK(left-1, right, string+"(");
		}
		// 左边括号生成之后，在生成右边的
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
            }else {	// 如果每个数只能计算一次，那么在保存的时候，只能保存一次。			
            	m.put(nums[i],i);
			}
        }
        return list;
	}
	
	
	// 递归模板
	public void generate(int level,int max,String str) {
		// 终结者
		if (level >= max) {
			
			System.out.println(str);
			return;
		}
		// 处理逻辑
//		String str1 = str+"(";
//		String str2 = str+")";
		// 下一层
		generate(level+1, max, str+"(");
		generate(level+1, max, str+")");
		// 清理
		
	}
	
	
}
