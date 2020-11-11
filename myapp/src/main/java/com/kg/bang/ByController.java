package com.kg.bang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ByController {

	@Autowired
	@Qualifier("byService")
	ByService byService;
	
	public void sayBy(String message) {
		System.out.println(byService.sayBy(message));
	}
}

// 1번쨰