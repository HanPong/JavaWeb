package com.atguigu.spring.beans.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx2=new ClassPathXmlApplicationContext("beans-factory.xml");
		Car car1=(Car)ctx2.getBean("car1");
		System.out.println(car1);
		
		Car car2=(Car)ctx2.getBean("car2");
		System.out.println(car2);
		
		
		
		
	}

}
