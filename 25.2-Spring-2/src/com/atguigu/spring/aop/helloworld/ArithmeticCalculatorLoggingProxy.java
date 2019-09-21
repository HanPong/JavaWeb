package com.atguigu.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;


public class ArithmeticCalculatorLoggingProxy {
	//�������
	//target��Ҫ������Ķ���
	private ArithmeticCalculator target;
	
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target=target;
	}
	public ArithmeticCalculator getLoggingProxy() {
		ArithmeticCalculator proxy=null;//proxy���Ǵ������
		
		
		//������Ķ�������һ������������м���
		ClassLoader loader=target.getClass().getClassLoader();
		//�������������ͣ�����������Щ����
		Class [] interfaces=new Class[] {ArithmeticCalculator.class};
		//�����ñ���������ʱ�����еķ���ʱ����ִ�еĴ���
		InvocationHandler h=new InvocationHandler() {
			
			//proxy���ڷ��ص��Ǹ��������һ������£���invoke�ж���ʹ�øö���
			//method���ڱ����õķ���
			//args���÷���ʱ����Ĳ���
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("invoke...");
				//��־1
				String methodName=method.getName();
				System.out.println("The method "+methodName+"begins with "+Arrays.asList(args));
				//ִ�з���
				Object result=method.invoke(target, args);
				//��־2
				System.out.println("The method "+methodName+"ends with "+result);
				return result;
			}
		};
		
		proxy=(ArithmeticCalculator)Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}
}
