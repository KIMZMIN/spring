package com.yedam.spring.anotation;

import org.springframework.stereotype.Component;

@Component
public class Chef {
	public void cooking(){
		System.out.println("anotation 방식");
	}
}
