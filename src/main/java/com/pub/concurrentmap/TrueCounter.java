package com.pub.concurrentmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 对falseCounter.java    改进
 * 
 * 加锁会影响服务器的性能
 * 可以采用CAS 的操作。可以保证比较和设置的是一个原子操作，当A线程尝试添加访问数量的时候
 * 访问数正在被修改的时候，就replace ，而我们就一直循环，不断的获取最新值，直到成功，及完成了统计。
 * @author JOINT
 *
 */
public class TrueCounter {

	
	// 定义保存接口和访问数量的map
	private static Map<String, Long> urlCounterMap = new ConcurrentHashMap<String, Long>();
	
	// 调用的接口，添加 访问次数
	// 这里使用CAS操作  循环去获取值，直到成功
	public  void  addCounter(String urlStr) {
		// 查看是否存在接口
		Long long1,tempValue;
		
		while (true) {
			long1 = urlCounterMap.get(urlStr);
			if(long1 == null) {
				tempValue = 1L;
				//第一次初始化成功，推出循环
				//如果指定的key尚未与value关联(或映射为null)，
				//则将key其与给定值value关联并返回null，否则将返回当前值
				if(urlCounterMap.putIfAbsent(urlStr, 1L) == null)
					break;
			}else {
				tempValue = long1 + 1;
				// 如果添加访问数成功，推出循环
				/**
				 * 仅当当前映射到指定值时，替换指定键的项.如果值被替换，则为真
				 */
				if(urlCounterMap.replace(urlStr, long1, tempValue))
					break;
			}
		}
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
		
		TrueCounter counter = new TrueCounter();
		
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
	 * java 的concurrent包下提供了大量的CAS操作，不用加锁也可以实现原子操作
	 * 
	 * 最后介绍一个和主题非常贴切的并发容器：Guava 包中 AtomicLongMap，使用他来做计数器非常容易。
	 */
}
