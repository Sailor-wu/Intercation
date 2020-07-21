package com.leetcode;

public class Sanyuan {

	public static void main(String[] args) {
		int [] arr = new int[] {1,2,3,4,5};
		
		boolean flg = new Sanyuan().isTrue(arr);
		
		System.out.println("flg : "+flg);
	}

	private boolean isTrue(int[] nums) {
		int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
        int len = nums.length;
        if (len < 3) {
			return false;
		}
		for(int i=0;i<len;++i)  {
            if(nums[i]<=min1)
                min1=nums[i];
            else if(nums[i]<=min2)
                min2=nums[i];
            else
                return true;
        }
        return false; 
	}
}
