package com.graph;
/**
 * 遍历图：深度优先遍历搜索
 * @author W.hy
 *
 */
public class DFSTraverse {

	AMGraph amGraph;
	public DFSTraverse(AMGraph amGraph) {
		this.amGraph = amGraph;
		// 初始化被访问顶点
		amGraph.visited = new boolean[this.amGraph.vexs.length];
		for (int i = 0; i < this.amGraph.vexs.length; i++) {
			this.amGraph.visited[i] = false;
		}
	}
	/** 深度优先遍历搜索 */
	public void dfsVisited() {
		for (int i = 0; i < this.amGraph.visited.length; i++) {
			if(!this.amGraph.visited[i]) {
				//对未访问的顶点调用深度优先遍历算法
				dfs_AM(i);
			}
		}
	}
	/**
	 * 遍历
	 * @param site
	 */
	private void dfs_AM(int site) {
		System.out.println(this.amGraph.vexs[site]); 
		this.amGraph.visited[site] = true; // 标记为已访问
		for (int i = 0; i < this.amGraph.vexs.length; i++) {
			//依次查找未访问邻接点，并以该邻接点为始点调用深度优先遍历算法
			if(this.amGraph.arcs[site][i] != 0 && !this.amGraph.visited[i]) {
				//输入深度优先遍历的开始顶点
				this.dfs_AM(i);
			}
		}
	}
}
