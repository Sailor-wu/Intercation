package com.pub.copyonwrite;

import java.util.List;

/**
 * 读
 * @author JOINT
 *
 */
public class ReadThread implements Runnable {

	private List<Integer> list;
	
	public ReadThread(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		System.out.print("线程："+Thread.currentThread().getName()+"\t");
		for (Integer integer : list) {
			System.out.print(integer+" - ");
		}
		System.out.println();
	}

}
