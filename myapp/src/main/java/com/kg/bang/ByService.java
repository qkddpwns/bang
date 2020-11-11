package com.kg.bang;

import org.springframework.stereotype.Service;

@Service
public class ByService{
	
		public String sayBy(String message) {
			return "Bye~ "+ message;
		}
}
