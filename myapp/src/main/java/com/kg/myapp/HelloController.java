package com.kg.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
	
	@Autowired
	@Qualifier("helloService")
	IHelloService helloService; // Qualifier를 사용하지 않고 만약 다른 변수가 들어가면 에러 발생.
	
//	public HelloController(IHelloService helloService) {
//		this.helloService = helloService;
//	}
	
	public void sayHello(String message) {
		System.out.println(helloService.sayHello(message));
	}
	
}
