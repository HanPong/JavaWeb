package com.atguigu.spring.aop.impl;
import java.util.Arrays;
import java.util.List;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//�����������Ϊһ�����棬�Ȱ���������IOC������(@Component)��������Ϊһ������(@Aspect)
@Aspect
@Component
public class LoggingAspect {
	//�����е���ʽ
	@Pointcut("execution(public int com.atguigu.spring.aop.impl.ArithmeticCalculator.*(int,int))")
	public void declareJointPointExpoession() {}
	
	@Before("declareJointPointExpoession()")
	//������execution�Ĳ��־����е���ʽ����������
	//public void beforeMethod() {
	//System.out.println("The method begins...");
	//}
	public void beforeMethod(JoinPoint joinpoint) {//JoinPoint���ӵ�
		String methodName=joinpoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinpoint.getArgs());
		System.out.println("The method"+methodName+"begins with"+args);
	}
	
	//����֪ͨ
	//�ں���֪ͨ�л����ܷ���Ŀ�귽��ִ�еĽ��
	@After("execution(public int com.atguigu.spring.aop.impl.ArithmeticCalculator.*(int,int))")
	public void afterMethod(JoinPoint joinpoint) {//JoinPoint���ӵ�
		String methodName=joinpoint.getSignature().getName();
		System.out.println("The method"+methodName+"ends");
	}
	
	//����֪ͨ
	//�ڷ�������ִ�н���ʱ��ִ�еĴ���
	//����֪ͨ�ǿ��Է��ʵ���������ֵ��
	@AfterReturning(value="execution(public int com.atguigu.spring.aop.impl.ArithmeticCalculator.*(..))",
			returning="result")
	public void afterReturning(JoinPoint joinpoint,Object result) {
		String methodName=joinpoint.getSignature().getName();
		System.out.println("The method"+methodName+"ends with"+result);
	}

	
	

}
