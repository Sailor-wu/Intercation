package com.proxy.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{

	private Enhancer enhancer = new Enhancer();  
	 public Object getProxy(Class clazz){  
	  //设置需要创建子类的类  
	  enhancer.setSuperclass(clazz);  
	  enhancer.setCallback(this);  
	  //通过字节码技术动态创建子类实例  
	  return enhancer.create();  
	 }  

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		 System.out.println("代理之前处理.....");
		 Object result = proxy.invokeSuper(obj, args);
		 System.out.println("代理之后处理.....");
		return result;
	}

}
