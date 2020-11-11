package com.kg.bang;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ByMain {

	public static void main(String[] args) {
		AbstractApplicationContext con = new GenericXmlApplicationContext("app.xml");
		ByController controller = con.getBean(ByController.class);
		controller.sayBy("방예준");
		con.close();
	}
}
// 2번째
