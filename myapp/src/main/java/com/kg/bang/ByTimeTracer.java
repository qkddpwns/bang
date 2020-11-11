package com.kg.bang;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ByTimeTracer {
	
//	@Around(value="execution(* com..ByController.sayBy(..))")
//	public Object bytrace(ProceedingJoinPoint joinPoint) throws Throwable {  // joinPoint는 우리가 지정(xml or ano에 작성한 곳)한 메서드라고 생각하면 된다.
//		Signature s = joinPoint.getSignature();
//		String methodName = s.getName();
//		System.out.println("[Log]Before : "+methodName+" time check start");
//		long startTime = System.nanoTime();
//		Object result = joinPoint.proceed();
//		long endTime = System.nanoTime();
//		System.out.println("[Log]after : " +methodName+" time check end");
//		System.out.println("[Log]"+methodName+" Proceeding time is"+(endTime-startTime)+"ns");
//		return result;
//	}
	
	@Around(value="within(com..ByService)")
	public Object bytrace(ProceedingJoinPoint joinPoint) throws Throwable {  // joinPoint는 우리가 지정(xml or ano에 작성한 곳)한 메서드라고 생각하면 된다.
		Signature s = joinPoint.getSignature();
		System.out.println("클래스 : "+s.getDeclaringTypeName()+", 메서드 : "+s.getName()+"시작");
		System.out.println("시작 시각 : "+new java.util.Date());
		long startTime = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		System.out.println("종료 시각 : "+new java.util.Date());
		System.out.println("클래스 : "+s.getDeclaringTypeName()+", 메서드 : "+s.getName()+"종료");
		System.out.printf("실행 시간 : %.4f",(endTime-startTime)/1000.0);
		return result;
	
	}
	
}
