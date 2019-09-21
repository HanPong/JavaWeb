package com.atguigu.spring.aop.xml;
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


public class LoggingAspect {

	public void beforeMethod(JoinPoint joinpoint) {//JoinPoint连接点
		String methodName=joinpoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinpoint.getArgs());
		System.out.println("The method"+methodName+"begins with"+args);
	}

	public void afterMethod(JoinPoint joinpoint) {//JoinPoint连接点
		String methodName=joinpoint.getSignature().getName();
		System.out.println("The method"+methodName+"ends");
	}
	
	
	public void afterReturning(JoinPoint joinpoint,Object result) {
		String methodName=joinpoint.getSignature().getName();
		System.out.println("The method"+methodName+"ends with"+result);
	}

	
	

}
