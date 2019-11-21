package com.pub.copyonwrite;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyList {

	public static void main(String[] args) {
		// 创建线程同时对一个List 进行操作
		
		List<Integer> tempList1 = Arrays.asList(new Integer [] {1,2,3});
		List<Integer> tempList = new CopyOnWriteArrayList<Integer>(tempList1);
		
//		List<Integer> tempList = new ArrayList<Integer>(tempList1);
		//2、模拟多线程对list进行读和写
        ExecutorService executorService = Executors.newFixedThreadPool(10);
		
        executorService.execute(new WriteThread(tempList));
        executorService.execute(new ReadThread(tempList));
        executorService.execute(new WriteThread(tempList));
        executorService.execute(new ReadThread(tempList));
        executorService.execute(new WriteThread(tempList));
        executorService.execute(new ReadThread(tempList));
//        tempList1.add(123);
        executorService.shutdown();
	}
}
