package com.suanfa4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class TowSum {

	public static void main(String[] args) {
		int size = 100000000;// 2147483647
		int sum  = 100000000;// sum
		int max = 2147483647;
		int arr [] = new int[size];
		for (int i = 0; i < size; i++) {
//			arr[i] = ThreadLocalRandom.current().nextInt(1000);
			arr[i] = i;
		}
		System.out.println("数组元素");
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i]+"\t");
//		}
		long start = System.currentTimeMillis()/1000;
		//1. 暴力拆解  一个一个比对。外层 a  内层 b 从a+1 开始
		int blCount = 0;
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = i+1; j < arr.length; j++) {
//				if(arr[i] + arr[j] == sum) {
//					blCount++;
////					System.out.print(arr[i] +" + "+ arr[j]+" = "+sum+"\t");
////					if (i % 10 == 0) {
////						System.out.println();
////					}
//				}
//			}
//		}
		System.out.println();
		System.out.println("数量："+blCount+"时间："+(System.currentTimeMillis()/1000 - start));
		
		
		//2.先排序，使用二叉搜索法  搜索 sum - a  b的值是否再数组中
		// 外层a  找b 是否存在
		start = System.currentTimeMillis()/1000;
		blCount = 0;
		System.out.println("清零："+blCount+"时间:"+start);
		
//		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			
			int  b = find_b(arr,sum -arr[i]);
			if (b > 0 && b > i) {
				blCount++;
//				System.out.print(arr[i] +" + "+arr[b] +" = "+sum+"\t");
//				if (i % 10 == 0) {
//					System.out.println();
//				}
			}
		}
		
		System.out.println("数量："+blCount+"时间："+(System.currentTimeMillis()/1000 - start));
		start = System.currentTimeMillis()/1000;
		blCount = 0;
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		int[] a =useMap(map,sum, arr);
		Iterator<Integer> iterator = map.keySet().iterator();
		int cou = 0;
//		while (iterator.hasNext()) {
//			Integer integer = (Integer) iterator.next();
//			System.out.print(integer+"+"+map.get(integer)+"="+sum);
//			if (cou == 10) {
//				System.out.println();
//				cou = 0;
//			}
//		}
		System.out.println("数量："+map.size()+"时间："+(System.currentTimeMillis()/1000 - start));
	}

	private static int[] useMap(Map<Integer,Integer> map,int sum, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int complement = sum -arr[i];
			if (map.containsKey(complement)) {
				 return new int[] { map.get(complement), i };
			}
			map.put(arr[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	/**
	 * 二分查找法,查找 b 是否存在，存在就返回下标 否则返回-1
	 * @param arr
	 * @param b
	 * @return b
	 */
	private static int find_b(int[] arr, int b) {
		int left = 0; // 最左
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
}
