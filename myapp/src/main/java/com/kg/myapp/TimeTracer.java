package com.kg.myapp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeTracer {
	
	@Around(value="execution(* com..HelloController.sayHello(..))")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		Signature s = joinPoint.getSignature();
		String methodName = s.getName();
		System.out.println("[Log]Before : "+methodName+" time check start");
		long startTime = System.nanoTime();
		Object result = joinPoint.proceed();
		long endTime = System.nanoTime();
		System.out.println("[Log]after : " +methodName+" time check end");
		System.out.println("[Log]"+methodName+" Proceeding time is"+(endTime-startTime)+"ns");
		return result;
	}
}
