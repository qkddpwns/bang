package com.kg.myapp;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface myAnnotation {  //추상메서드 형식으로 구성

//	String name() default "기본값입니다.";
	
}
