package com.atguigu.spring.beans.cycle;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println(" postProcessAfterInitialization:"+bean+","+beanName);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println(" postProcessBeforeInitialization:"+bean+","+beanName);
		
		//Caution here
		Car car=new Car();
		car.setBrand("Ford");
		
		return car;
	}
//bean:bean实例本身
//beanName:IOC容器配置的bean的id
//返回值：是实际上返回给用户的那个bean，注意：可以在以上两个方法中修改返回的bean，甚至返回一个新bean
}
