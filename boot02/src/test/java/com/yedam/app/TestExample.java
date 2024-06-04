package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.aop.service.AaaService;

@SpringBootTest //테스트환경이지만 기존 환경을 그대로 불러온다
public class TestExample {
	@Autowired
	AaaService aaaService;
	
	@Test
	public void aaaInsert() {
		aaaService.insert();
	}
}
