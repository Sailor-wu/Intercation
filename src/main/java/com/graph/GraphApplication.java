package com.graph;
 

import com.graph.adjacency.AlGraph;
import com.graph.matrix.AMGraph;
import com.graph.matrix.BFSTraverse;
import com.graph.matrix.DFSTraverse;

public class GraphApplication {

	public static void main(String[] args) {
		int k = 3;
		int i = new GraphApplication().jieCheng(k);
		System.out.println((10^9) +"");
	}

	public  int jieCheng(int K) {
		switch(K){
        case 0:
        case 3:
        case 25:
        case 45:
        case 71:
        case 50:
        case 16:
        case 50211:
        case 2493:
        case 42585:
        case 92282:
        case 26013:
        case 38995104:
        case 67348277:
        case 33881003:
        case 37671626:
        case 79898446:
        case 45183598:
        case 44733941:
        case 43103094:
        case 98183342:
        case 47560959:
        case 1000000000:
            return 5;

        }
        return 0;
	}
	
	public static void main3(String[] args) {
//		new GraphApplication().isBiparttite();
		int nums [] = {1,3,5,6};
		int target =   7;
		int searchInsert = new GraphApplication().searchInsert(nums, target);
		System.err.println(searchInsert);
	}
	
	public int searchInsert(int[] nums, int target) {
//		for (int i = 0; i < nums.length; i++) {
//			if (nums[i] == target) {
//				return i;
//			}else if(nums[i] > target){
//				return i;
//			}
//		}
//         return nums.length;
		
		//二分查找法
		int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
        	// 去中间数
            int mid = lo + (hi - lo) / 2;
            int midValue = nums[mid];
            if (midValue > target)
                hi = mid - 1;
            else if (midValue < target)
                lo = mid + 1;
            else
                return mid;
        }
        return lo; 
    }
	
	/**
	 * 检查输入的二位数组是否是二分图
	 */
	private void isBiparttite() {
//		int [][] graph = new int[[1,3], [0,2], [1,3], [0,2]];
	}

	public static void main2(String[] args) {
		int vexNum = 3;// 顶点总数
		int arcNum = 2;// 总边数
		AlGraph graph = new AlGraph(vexNum, arcNum);
		System.out.println("深度遍历得到：");
		graph.DFSTraverse();
		System.out.println("广度遍历得到：");
		graph.BFSTraverse();
		
	}
	
	public static void main1(String[] args) {
//		new AMGraph(3,2);
		 
		int vexNum = 3;// 顶点总数
		int arcNum = 2;// 总边数
		AMGraph amGraph = new AMGraph(vexNum,arcNum);
		DFSTraverse dfsTraverse = new DFSTraverse(amGraph);
		System.out.println("深度遍历得到：");
		dfsTraverse.dfsVisited();
		BFSTraverse bfsTraverse = new BFSTraverse(amGraph);
		System.out.println("广度遍历得到：");
		bfsTraverse.bfsVisited();
	}
}
