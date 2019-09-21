package com.atguigu.spring.aop.helloworld;

public class Main {
	public static void main(String[] args) {
	//ArithmeticCalculator arithmeticCalculator=new ArithmeticCalculatorImpl();
	ArithmeticCalculator target=new ArithmeticCalculatorImpl();
	ArithmeticCalculator proxy=new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
	
	int result=proxy.add(1, 2);
	System.out.println(">>"+result);
	result=proxy.mul(4, 2);
	System.out.println(">>"+result);
	
	}

}
