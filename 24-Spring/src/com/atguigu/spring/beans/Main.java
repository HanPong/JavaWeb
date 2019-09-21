package com.atguigu.spring.beans;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*//创建对象，可交给Spring完成
		HelloWorld helloWorld=new HelloWorld();
		//为name赋值，可交给Spring完成
		helloWorld.setName("Han Pong");*/
		
		//1.创建Spring的IOC容器对象，对容器初始化
		//ApplicationContext代表IOC容器
		//ClassPathXmlApplicationContext是ApplicationContext接口的实现类
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.从IOC容器中获取Bean实例
		//利用id定位到IOC容器中的bean，还可以利用类型定位，要求容器中只能有一个该类型的Bean
		HelloWorld helloWorld=(HelloWorld)ctx.getBean("helloWorld");
		helloWorld.hello();
	
	}

}
