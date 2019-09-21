package com.atguigu.spring.beans;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*//�������󣬿ɽ���Spring���
		HelloWorld helloWorld=new HelloWorld();
		//Ϊname��ֵ���ɽ���Spring���
		helloWorld.setName("Han Pong");*/
		
		//1.����Spring��IOC�������󣬶�������ʼ��
		//ApplicationContext����IOC����
		//ClassPathXmlApplicationContext��ApplicationContext�ӿڵ�ʵ����
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.��IOC�����л�ȡBeanʵ��
		//����id��λ��IOC�����е�bean���������������Ͷ�λ��Ҫ��������ֻ����һ�������͵�Bean
		HelloWorld helloWorld=(HelloWorld)ctx.getBean("helloWorld");
		helloWorld.hello();
	
	}

}
