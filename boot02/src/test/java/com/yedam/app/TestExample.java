package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yedam.app.aop.service.AaaService;

@SpringBootTest //테스트환경이지만 기존 환경을 그대로 불러온다
public class TestExample {
	//AOP테스트
	@Autowired
	AaaService aaaService;
	
	//@Test
	public void aaaInsert() {
		aaaService.insert();
	}
	
	//Spring Security Test
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	public void testCencoder() {
		String password = "1234";  						 //사용자가 입력한 비밀번호
		String enPwd = passwordEncoder.encode(password); //DB에 암호화되어 저장된 비밀번호 (단방향암호화) 
		System.out.println("enPwd : "+ enPwd);
		
		boolean matchResult = passwordEncoder.matches(password, enPwd);
		System.out.println("match : " + matchResult);
	}

}
