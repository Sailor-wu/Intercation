package com.graph;

import java.util.Scanner;

public class GraphApplication {

	public static void main(String[] args) {
//		new AMGraph(3,2);
		
		Scanner sc = new Scanner(System.in);
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
