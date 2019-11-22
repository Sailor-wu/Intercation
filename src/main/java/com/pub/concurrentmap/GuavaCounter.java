package com.pub.concurrentmap;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.AtomicLongMap;

public class GuavaCounter {
	
	private AtomicLongMap<String> urlCounter3 = AtomicLongMap.create();

	public long addCounter(String url) {
	  long newValue = urlCounter3.incrementAndGet(url);
	  return newValue;
	}


	public Long getCounter(String url) {
	  return urlCounter3.get(url);
	}
	
	// 测试  模拟多线程多次  访问  记录访问次数
		public static void main(String[] args) {
			// 开是个线程
			ExecutorService service = Executors.newFixedThreadPool(10);
			
			GuavaCounter counter = new GuavaCounter();
			
			String urlString = "http://localhost:8080/9189";
			CountDownLatch downLatch = new CountDownLatch(10000);
			// 访问 10000次
			for (int i = 0; i < 10000; i++) {			
				service.execute(new Runnable() {
					
					@Override
					public void run() {
						counter.addCounter(urlString);
						downLatch.countDown();
					}
				});
			}		
			
			try {
				downLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			service.shutdown();
			
			
			System.out.println("统计访问次数为："+counter.getCounter(urlString));
			
			
		}
}
