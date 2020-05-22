package com.design.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 单例模式
 * 
 * @author W.hy 
 */
public class Singleton2 implements Serializable{
	private static final long serialVersionUID = -876643920835982129L;
	
	/* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */  
    private static Singleton2 instance = null;  
    /* 私有构造方法，防止被实例化 */  
    private Singleton2() {}  
  
    //  这个类的加载过程是线程互斥的。这样当我们第一次调用getInstance的时候，
    // JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕，这样我们就不用担心上面的问题
    /* 此处使用一个内部类来维护单例 */  
    private static class SingletonFactory {  
        private static Singleton2 instance = new Singleton2();  
    }  
  
    /* 获取实例 */  
    public static Singleton2 getInstance2() {  
        return SingletonFactory.instance;  
    }  
	
    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
    public Object readResolve() throws ObjectStreamException{  
        return instance;  
    } 
}
