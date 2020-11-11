/*
 * package com.kg.bang;
 * 
 * import org.aspectj.lang.JoinPoint; import org.aspectj.lang.Signature; import
 * org.aspectj.lang.annotation.After; import org.aspectj.lang.annotation.Aspect;
 * import org.aspectj.lang.annotation.Before; import
 * org.aspectj.lang.annotation.Pointcut; import
 * org.springframework.stereotype.Component;
 * 
 * @Component
 * 
 * @Aspect public class ByLogAspect {
 * 
 * @Pointcut(value = "execution(* com..ByController.sayBy(..))") private void
 * byPointcut() {
 * 
 * }
 * 
 * @Before("byPointcut()") public void beforLog(JoinPoint joinPoint) { Signature
 * s = joinPoint.getSignature();
 * System.out.println("클래스 :"+s.getDeclaringTypeName()+", 메서드  "+s.getName()
 * +" 시작"); }
 * 
 * @After("byPointcut()") public void afterLog(JoinPoint joinPoint) { Signature
 * s = joinPoint.getSignature();
 * System.out.println("클래스 :"+s.getDeclaringTypeName()+", 메서드  "+s.getName()
 * +" 종료"); }
 * 
 * }
 */