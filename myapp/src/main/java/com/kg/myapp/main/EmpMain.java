package com.kg.myapp.main;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kg.myapp.service.EmpService;
import com.kg.myapp.vo.EmpVO;

public class EmpMain {

	public static void main(String[] args) {
		AbstractApplicationContext con = new GenericXmlApplicationContext("app.xml");
		EmpService empService = con.getBean(EmpService.class);
		System.out.println(empService.selectEmployee(100));
		/*
		 * List<EmpVO> empList = empService.selectAllEmployee(); for(EmpVO emp :
		 * empList) { System.out.println(emp); }
		 */

	}
}
