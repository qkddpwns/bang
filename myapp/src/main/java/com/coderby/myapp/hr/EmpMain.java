package com.coderby.myapp.hr;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.coderby.myapp.hr.dao.IEmpService;

public class EmpMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("app.xml");
		IEmpService empService = context.getBean("empService", IEmpService.class);
		/*
		 * System.out.println(empService.getEmpCount());
		 * System.out.println(empService.getEmpCount(30));
		 * System.out.println(empService.getEmpList());
		 * System.out.println(empService.getAllManagerId());
		 */
		empService.deleteEmp(100);
		context.close();
	}
}
