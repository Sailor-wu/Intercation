package com.pub.copyonwrite;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CopySet {

	
	public static void main(String[] args) {
		// 实例化一个CopyOnWriteSet 对象
		Set<String> set = new CopyOnWriteArraySet<>();
		// 创建
        ExecutorService service = Executors.newFixedThreadPool(12);
        int times = 100;
        AtomicInteger flag = new AtomicInteger(0);
        for(int i = 0; i < times; i ++){
            service.execute(()->{
            	/**
            	 * 在add元素时，采用的是可重入锁来实现线程安全。
            	 * 源码；
            	 private boolean addIfAbsent(E e, Object[] snapshot) {
            	 	final ReentrantLock lock = this.lock;
			        lock.lock();
			        try {
			            Object[] current = getArray();
			            int len = current.length;
			            if (snapshot != current) {
			                // Optimize for lost race to another addXXX operation
			                int common = Math.min(snapshot.length, len);
			                for (int i = 0; i < common; i++)
			                    if (current[i] != snapshot[i] && eq(e, current[i]))
			                        return false;
			                if (indexOf(e, current, common, len) >= 0)
			                        return false;
			            }
			            Object[] newElements = Arrays.copyOf(current, len + 1);
			            newElements[len] = e;
			            setArray(newElements);
			            return true;
			        } finally {
			            lock.unlock();
			        }
			     }
			     
			     	原子性     将给定值添加到当前值。
			     flg.getAndAdd(int)
            	 */
                set.add(Thread.currentThread().getName()+":\ta" + flag.getAndAdd(1));
            });
        }
        service.shutdown();
        try {
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(set.size());
        for (String string : set) {
			System.out.println(string);
		}
	}
}
