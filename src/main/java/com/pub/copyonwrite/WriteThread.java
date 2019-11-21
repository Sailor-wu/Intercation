package com.pub.copyonwrite;

import java.util.List;
import java.util.Random;

/**
 * 写
 * @author JOINT
 *
 */
public class WriteThread implements Runnable {

	private List<Integer> list;
	
	public WriteThread(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		int nextInt = new Random().nextInt();
		System.out.println("线程："+Thread.currentThread().getName()+"\t create integer :"+nextInt);
		this.list.add(nextInt);
	}

}
