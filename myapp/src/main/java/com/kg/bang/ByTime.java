package com.kg.bang;

import org.springframework.stereotype.Component;

@Component
public class ByTime {

	public void timeLog() {
		System.out.println(new java.util.Date());
	}
	
}
