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

//把这个类声明为一个切面，先把这个类放入IOC容器中(@Component)，再声明为一个切面(@Aspect)
@Aspect
@Component
public class LoggingAspect {
	//重用切点表达式
	@Pointcut("execution(public int com.atguigu.spring.aop.impl.ArithmeticCalculator.*(int,int))")
	public void declareJointPointExpoession() {}
	
	@Before("declareJointPointExpoession()")
	//括号里execution的部分就是切点表达式，可以重用
	//public void beforeMethod() {
	//System.out.println("The method begins...");
	//}
	public void beforeMethod(JoinPoint joinpoint) {//JoinPoint连接点
		String methodName=joinpoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinpoint.getArgs());
		System.out.println("The method"+methodName+"begins with"+args);
	}
	
	//后置通知
	//在后置通知中还不能访问目标方法执行的结果
	@After("execution(public int com.atguigu.spring.aop.impl.ArithmeticCalculator.*(int,int))")
	public void afterMethod(JoinPoint joinpoint) {//JoinPoint连接点
		String methodName=joinpoint.getSignature().getName();
		System.out.println("The method"+methodName+"ends");
	}
	
	//返回通知
	//在方法正常执行结束时所执行的代码
	//返回通知是可以访问到方法返回值的
	@AfterReturning(value="execution(public int com.atguigu.spring.aop.impl.ArithmeticCalculator.*(..))",
			returning="result")
	public void afterReturning(JoinPoint joinpoint,Object result) {
		String methodName=joinpoint.getSignature().getName();
		System.out.println("The method"+methodName+"ends with"+result);
	}

	
	

}
