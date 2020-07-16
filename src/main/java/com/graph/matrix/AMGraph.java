package com.graph;

import java.util.Scanner;

public class AMGraph extends Graph {

	// 默认构造
	public AMGraph() {  }

	/**
	 * 构造图
	 * 输入点的个数和边的个数
	 * @param vexNum 点
	 * @param arcNum 边
	 */
	public AMGraph(int vexNum,int arcNum) {
		this.vexs = new String [vexNum];
		this.arcs = new int[vexNum][vexNum];
		// 手动输入顶点的值
		Scanner sc = new Scanner(System.in);
		System.out.println("请依次输入顶点值，按回车输入下一个点：");
		for (int i = 0; i < vexNum; i++) {
			this.vexs[i] = sc.next();
		}
		System.out.println("你输入的点值：");
		for (int i = 0; i < vexs.length; i++) {
			System.out.print(vexs[i]+"\t");
		}
		System.out.println();
		// 初始化边集
		for (int i = 0; i < vexNum ; i++) {
			for (int j = 0; j < vexNum; j++) {
				// 默认没有边
				arcs[i][j] = 0;
			}
		}
		// 开始建立边集
		String vex1 ="";  // 顶点
		String vex2 ="";
		for (int i = 0; i < arcNum; i++) {
			int vex1Site = 0;// 顶点的位置
			int vex2Site = 0;
			System.out.print("请输入第" + (i+1) + "条边所依附的两个顶点，按回车输入下一个点：");
			vex1 = sc.next();
			vex2 = sc.next();
			// 查找顶点位置
			for (int j = 0; j < this.vexs.length; j++) {
				if (vex1.equals(this.vexs[j])) {
					vex1Site = j;
					break;
				}
				if (j == this.vexs.length - 1) {
					System.out.println("未找到顶点"+vex1+"。");
					i--;
					continue;
				}
			}
			for (int j = 0; j < this.vexs.length; j++) {
				if (vex2.equals(this.vexs[j])) {
					vex2Site = j;
					break;
				}
				if (j == this.vexs.length - 1) {
					System.out.println("未找到顶点"+vex2+"。");
					i--;
					continue;
				}
			}
			
			// 检查边是否已存在
			if(this.arcs[vex1Site][vex2Site] != 0) {
				System.out.println("边已存在。");
				i--;
				continue;
			}else {
				this.arcs[vex1Site][vex2Site] = 1;
				this.arcs[vex2Site][vex1Site] = 1;// 对称边
			}
			
		}
		System.out.println("基于邻接矩阵无向图已经创建完成。");
		sc.close();
	}
	
	
}
