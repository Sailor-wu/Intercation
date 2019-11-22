package com.pub.concurrentmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 要实现一个：接口统计的方法
 * 考虑：
 * 1.多线程访问，需要选择合适的并发容器  concurrentHashMap 
 * 2.分布式下多个实例统计需要共享内存     可以使用 redis。
 * 3.统计应尽量不消耗服务器性能		不适用同步锁之类影响服务器性能
 * @author JOINT
 */
public class FalseCounter {
	
	// 定义保存接口和访问数量的map
	private static Map<String, Long> urlCounterMap = new ConcurrentHashMap<String, Long>();
	
	// 调用的接口，添加 访问次数
	public  void  addCounter(String urlStr) {
		// 查看是否存在接口
		Long long1 = urlCounterMap.get(urlStr);
		if(long1 == null) {
			long1 = 1L;
		}else {
			long1 = long1 + 1;
		}
		urlCounterMap.put(urlStr, long1);
	}
	
	// 获取访问次数
	public Long getCounter(String url) {
		// 预防返回 null  捕获
		return urlCounterMap.get(url) == null ? 0L : urlCounterMap.get(url);
	}
	
	// 测试  模拟多线程多次  访问  记录访问次数
	public static void main(String[] args) {
		// 开是个线程
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		FalseCounter counter = new FalseCounter();
		
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
	
	/**
	 * 解析：
	 * 这里显然没有同步到
	 * 问题出在哪里？
	 * 问题出现在添加访问次数的时候，concurrentHashMap  能保证的是每个操作本身是线程安全的
	 * 但是我们的添加方法，对Map的操作是一个组合，十个线程在操作，先get  在put 所以出现了覆盖的现象
	 * 那你这里会说了。添加锁
	 * 那不就是违背了不影响服务器性能的初衷了吗？因为锁的开销很大。
	 * 这么改进？
	 * 
	 * 查看TrueCounter.java
	 */
	
}
