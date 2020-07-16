package com.graph.adjacency;

import java.util.LinkedList;
import java.util.Scanner;

public class AlGraph extends Graph{

	public AlGraph() {}
	public AlGraph(int vexNum,int arcNum) {
		this.aLGraph_Heads = new AlGraph_Head[vexNum];
		
		System.out.print("请依次输入顶点值，以空格隔开：");
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < vexNum; i++) {  //建立顶点数组存储点结点
			this.aLGraph_Heads[i] = new AlGraph_Head(sc.next());
		}
		String vex1 ="";  
		String vex2 ="";
		// 存储边的
		for (int i = 0; i < arcNum; i++) {
			int vex1Site = 0;// 顶点的位置
			int vex2Site = 0;
			System.out.print("请输入第" + (i+1) + "条边所依附的两个顶点，以空格隔开：");
			vex1 = sc.next();
			vex2 = sc.next();
			for (int j = 0; j < aLGraph_Heads.length; j++) {
				if (this.aLGraph_Heads[j].getData().equals(vex1)) {
					vex1Site = j;
					break;
				}
				if (j==this.aLGraph_Heads.length-1) {
					System.out.println("未找到节点："+vex1);
					i--;
					continue;
				}
			}
			
			for (int j = 0; j < aLGraph_Heads.length; j++) {
				if (this.aLGraph_Heads[j].getData().equals(vex2)) {
					vex2Site = j;
					break;
				}
				if (j==this.aLGraph_Heads.length-1) {
					System.out.println("未找到节点："+vex2);
					i--;
					continue;
				}
			}
			
			AlGraph_Arc arc = this.aLGraph_Heads[vex1Site].getGraph_Arc();
			
			while (arc != null) {
				
				if (arc.getAdjVexSite() == vex2Site) {
					System.out.println("该边已存在。");
					i--;
					continue;
				}
				arc = arc.getNextArc();
				
			}
			this.aLGraph_Heads[vex1Site].setGraph_Arc(new AlGraph_Arc(vex2Site, this.aLGraph_Heads[vex1Site].getGraph_Arc()));
			this.aLGraph_Heads[vex2Site].setGraph_Arc(new AlGraph_Arc(vex1Site, this.aLGraph_Heads[vex2Site].getGraph_Arc()));
		}
		
		System.out.println("基于邻接表的无向图创建成功！");
		sc.close();
	}
	
	public void  DFSTraverse() {
		this.visited = new boolean[this.aLGraph_Heads.length];
		for (int i = 0; i < this.visited.length; i++) {
			this.visited[i] = false;
		}
		
		for (int i = 0; i < this.visited.length; i++) {
			if(!this.visited[i]){
				DFS_AM(i);
			}
		}
	}
	// 深度遍历搜索
	private void DFS_AM(int site) {
		 System.out.println(this.aLGraph_Heads[site].getData());
		 
		 this.visited[site] = true;
		// 获取点结点中的边指针
		 AlGraph_Arc arc = this.aLGraph_Heads[site].getGraph_Arc();
		 while (arc!=null) {
			 //	 如果该边所连接的顶点的邻接点未访问，则以该邻接点为始点调用深度优先遍历算法
			if(!visited[arc.getAdjVexSite()]) {
				this.DFS_AM(arc.getAdjVexSite());
			}
			// 获取下一条边
			arc = arc.getNextArc();
		}
		 
	}
	
	public void BFSTraverse() {
		// 建立并初始化访问标志数组
		this.visited = new boolean[this.aLGraph_Heads.length];
		
		for (int i = 0; i < visited.length; i++) {
			this.visited[i] = false;
		}
		for (int i = 0; i < visited.length; i++) {
			BFS_AM(i);
		}
	}
	private void BFS_AM(int site) {
		 System.out.println(this.aLGraph_Heads[site].getData());
		 visited[site] = true;// 标记已访问
		 //  //利用队列实现广度优先遍历
		 LinkedList<Integer> linkedList = new LinkedList<Integer>();
		 linkedList.offer(site);
		 while (!linkedList.isEmpty()) {
			int vexSite = linkedList.poll();
			AlGraph_Arc alGraph_Arc = this.aLGraph_Heads[site].getGraph_Arc();
			while (alGraph_Arc!= null) {

				vexSite = alGraph_Arc.getAdjVexSite();
				if(!visited[site]) {
					System.out.println(aLGraph_Heads[site].getData());
					this.visited[site] = true;
					linkedList.offer(site);
				}
				alGraph_Arc = alGraph_Arc.getNextArc();
			}
		}
		 
	}
	
	
}
