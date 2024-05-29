package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.app.emp.service.EmpVO;

//Interface ...★
@Mapper
public interface EmpMapper {
	//DAO - Data Accept Object 를 위한 Interface

	//전체조회 - SELECT, 조건X, 결과가 여러건.
	public List<EmpVO> selectEmpAll();
	
	//단건조회 - 
	
	//등록
	
	//수정
	
	//삭제
	

	
	
}
