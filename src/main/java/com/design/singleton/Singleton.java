package com.design.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 单例模式
 * 
 * @author W.hy 
 */
public class Singleton implements Serializable{
	private static final long serialVersionUID = -876643920835982129L;
	
	/* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */  
    private static Singleton instance = null;  
  
    //   第一种 在Java指令中创建对象和赋值操作是分开进行的，
    // 也就是说instance = new Singleton();语句是分两步执行的。 或存在线程问题
    /* 私有构造方法，防止被实例化 */  
    private Singleton() {}  
  
    /** 静态获取实例方法 */
    public static Singleton getInstance1() {
    	if (instance == null) {
			instance = new Singleton();
		}
    	return instance;
    }
    
    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
    public Object readResolve() throws ObjectStreamException{  
        return instance;  
    } 
}
