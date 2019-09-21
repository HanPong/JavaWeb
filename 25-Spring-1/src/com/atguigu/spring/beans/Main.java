package com.atguigu.spring.beans;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		//����HelloWorld��һ������
		//HelloWorld helloWorld=new HelloWorld();
		//Ϊname���Ը�ֵ
		//helloWorld.setName("HanPong");
		//����hello����
		//helloWorld.hello();
		
		//1.����Spring��IOC�������󣬳����������BeanFactory
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");//����·���¼��أ������Դ��ļ������
		            
		//ApplicationContext����һ����������,Class...˵������·����
		
		//2.��IOC�����л�ȡBeanʵ��
		HelloWorld helloWorld=(HelloWorld)ctx.getBean("helloWorld");
		//HelloWorld helloWorld=ctx.getBean(HelloWorld.class);
		
		
		helloWorld.hello();
		
		Car car=(Car)ctx.getBean("car");
		System.out.println(car);
		
		Person person=(Person)ctx.getBean("person");
		System.out.println(person);
	}

}
