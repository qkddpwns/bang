package com.kg.myapp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		AbstractApplicationContext con = new GenericXmlApplicationContext("app.xml");  //컨테이너(공간)를 만듬, xml을 가지고
		HelloController controller = con.getBean(HelloController.class);
		controller.sayHello("방예준");
		con.close();
	}
}