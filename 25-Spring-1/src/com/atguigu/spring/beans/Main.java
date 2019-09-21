package com.atguigu.spring.beans;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		//创建HelloWorld的一个对象
		//HelloWorld helloWorld=new HelloWorld();
		//为name属性赋值
		//helloWorld.setName("HanPong");
		//调用hello方法
		//helloWorld.hello();
		
		//1.创建Spring的IOC容器对象，除了这个还有BeanFactory
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");//从类路径下加载，还可以从文件里加载
		            
		//ApplicationContext声明一个容器对象,Class...说明在类路径下
		
		//2.从IOC容器中获取Bean实例
		HelloWorld helloWorld=(HelloWorld)ctx.getBean("helloWorld");
		//HelloWorld helloWorld=ctx.getBean(HelloWorld.class);
		
		
		helloWorld.hello();
		
		Car car=(Car)ctx.getBean("car");
		System.out.println(car);
		
		Person person=(Person)ctx.getBean("person");
		System.out.println(person);
	}

}
