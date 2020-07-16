package com.graph.matrix;

import java.util.LinkedList;

import org.jsoup.select.Evaluator.IsEmpty;

/**
 * 遍历图：广度优先遍历搜索
 * @author W.hy
 *
 */
public class BFSTraverse  {

	AMGraph amGraph;
	public BFSTraverse(AMGraph amGraph) {
		this.amGraph = amGraph;
		// 初始化访问
		this.amGraph.visited = new boolean[this.amGraph.vexs.length];
		for (int i = 0; i < this.amGraph.vexs.length; i++) {
			this.amGraph.visited[i] = false;
		}
	}
	
	public  void bfsVisited() {
		for (int i = 0; i < this.amGraph.visited.length; i++) {
			if (!this.amGraph.visited[i]) {
				bfs_AM(i);
			}
		}
	}
	/**
	 * 广度优先搜索
	 * @param i
	 */
	private void bfs_AM(int site) {
		System.out.println(this.amGraph.vexs[site]);
		this.amGraph.visited[site] = true;// 标记当前节点已经被访问
		// 借助队列来实现广度优先遍历
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		// 将访问过的顶点入队
		linkedList.offer(site);
		while (!linkedList.isEmpty()) {
			// 队头顶点出队
			int vexSite = linkedList.poll();
			for (int i = 0; i < this.amGraph.vexs.length; i++) {
				// 依次查找未访问的邻接点进行访问后入队
				if(this.amGraph.arcs[vexSite][i] != 0 && !this.amGraph.visited[i]) {
					System.out.println(this.amGraph.vexs[i]);
					this.amGraph.visited[i] = true;
					linkedList.offer(i);
				}
			}
		}
	}
}
