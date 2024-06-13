package com.yedam.app.rent.mapper;

import java.util.List;

import com.yedam.app.rent.service.RentVO;

public interface RentMapper {
	//전체조회
	public List<RentVO> seleteRentAll();
}
