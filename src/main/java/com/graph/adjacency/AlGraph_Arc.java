package com.graph.adjacency;
/**
 * 边类
 * @author W.hy
 *用来生成 边  节点
 */
public class AlGraph_Arc {

	private int adjVexSite = 0; // 该边连接的顶点的值
	private AlGraph_Arc nextArc;// 下一条边的指针
	
	public int getAdjVexSite() {
		return adjVexSite;
	}
	public AlGraph_Arc getNextArc() {
		return nextArc;
	}
	// 构造
	public AlGraph_Arc(int adjVexSite, AlGraph_Arc nextArc) {
		this.adjVexSite = adjVexSite;
		this.nextArc = nextArc;
	}
	
	
}
