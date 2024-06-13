package com.yedam.app.rent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.rent.mapper.RentMapper;
import com.yedam.app.rent.service.RentService;
import com.yedam.app.rent.service.RentVO;

@Service
public class RentServiceImpl implements RentService{
	@Autowired
	RentMapper rentMapper;

	@Override
	public List<RentVO> rentList() {
		return rentMapper.seleteRentAll();
	}
	
	
}
