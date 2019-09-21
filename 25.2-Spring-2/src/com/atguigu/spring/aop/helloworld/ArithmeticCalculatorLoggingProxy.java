package com.atguigu.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;


public class ArithmeticCalculatorLoggingProxy {
	//代理对象
	//target是要被代理的对象
	private ArithmeticCalculator target;
	
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target=target;
	}
	public ArithmeticCalculator getLoggingProxy() {
		ArithmeticCalculator proxy=null;//proxy就是代理对象
		
		
		//被代理的对象由哪一个类加载器进行加载
		ClassLoader loader=target.getClass().getClassLoader();
		//被代理对象的类型，即其中有哪些方法
		Class [] interfaces=new Class[] {ArithmeticCalculator.class};
		//当调用被代理对象的时候其中的方法时，该执行的代码
		InvocationHandler h=new InvocationHandler() {
			
			//proxy正在返回的那个处理对象，一般情况下，在invoke中都不使用该对象
			//method正在被调用的方法
			//args调用方法时传入的参数
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("invoke...");
				//日志1
				String methodName=method.getName();
				System.out.println("The method "+methodName+"begins with "+Arrays.asList(args));
				//执行方法
				Object result=method.invoke(target, args);
				//日志2
				System.out.println("The method "+methodName+"ends with "+result);
				return result;
			}
		};
		
		proxy=(ArithmeticCalculator)Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}
}
