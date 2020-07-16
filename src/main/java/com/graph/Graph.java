package com.graph;
/**
 * 创建基于邻接矩阵的无向图
 * @author W.hy
 * 邻接矩阵是一种利用一维数组记录点集信息，二维数组记录边集信息来表示图的表示法
 * 因此可以抽象出来一个图类，点集信息和边集信息抽象成属性表示
 * 需要实现 图的遍历，需要附设一个访问标志的数组 visited[]来记录被访问的节点。
 * 
 */
public class Graph {
	// 点集信息
	String [] vexs = null;
	// 边集信息
	int[][] arcs = null;
	  
	boolean visited [] = null;
}
