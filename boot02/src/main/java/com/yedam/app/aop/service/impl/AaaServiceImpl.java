package com.yedam.app.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AaaMapper;
import com.yedam.app.aop.service.AaaService;

@Service //AOP가 적용가능한 Bean
public class AaaServiceImpl implements AaaService {
	
	@Autowired
	AaaMapper aaaMapper;
	
	@Transactional  //자동으로 포인트컷으로 등록, 연결되어야하는 어드바이스 시점이 끌려옴? DML이 들어간 서비스만 사용하셈,.
	@Override
	public void insert() {
		aaaMapper.insert("101");
		aaaMapper.insert("a202");
	}
}
