package com.kg.myapp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	@Pointcut(value="execution(* com..HelloController.sayHello(..))")
	private void helloPointcut() {
		
	}
	@Before("helloPointcut()")
	public void beforeLog(JoinPoint joinPoint) {
		Signature s = joinPoint.getSignature();
		System.out.println("클래스 :"+s.getDeclaringTypeName()+", 메서드  "+s.getName()+" 시작");
	}
	@After("helloPointcut()")
	public void agterLog(JoinPoint joinPoint) {
		Signature s = joinPoint.getSignature();
		System.out.println("클래스 :"+s.getDeclaringTypeName()+", 메서드  "+s.getName()+" 종료");
	}
}
