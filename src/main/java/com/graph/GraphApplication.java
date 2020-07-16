package com.graph;
 

import com.graph.adjacency.AlGraph;
import com.graph.matrix.AMGraph;
import com.graph.matrix.BFSTraverse;
import com.graph.matrix.DFSTraverse;

public class GraphApplication {

	public static void main(String[] args) {
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
