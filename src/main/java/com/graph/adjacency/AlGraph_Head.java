package com.graph.adjacency;
/**
 * 顶点类
 * @author W.hy
 *用来生成   点    节点
 */
public class AlGraph_Head {

	private String data;  //点  节点的值
	private AlGraph_Arc graph_Arc; // 第一条边的指针
		
	public AlGraph_Head(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	} 
	public AlGraph_Arc getGraph_Arc() {
		return graph_Arc;
	}
	public void setGraph_Arc(AlGraph_Arc graph_Arc) {
		this.graph_Arc = graph_Arc;
	}
	
	
}
