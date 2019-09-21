package com.atguigu.spring.beans;
/*import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
*/
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*//创建对象，可交给Spring完成
		HelloWorld helloWorld=new HelloWorld();
		//为name赋值，可交给Spring完成
		helloWorld.setName("Han Pong");*/
		//1.创建Spring的IOC容器对象
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.从IOC容器中获取Bean实例
		
		helloWorld.hello();
	}

}
