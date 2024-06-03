package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptVO;
import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest //스프링과 junit을 연결해줌! junit은 spring을 모름
class Boot02ApplicationTests {
	
	@Autowired
	EmpMapper empMapper;
	
	@Autowired
	DeptMapper deptMapper;
	
	//전체조회
	//@Test
	public void deptList() {
		List<DeptVO> list = deptMapper.selectDeptAll();
		assertTrue(!list.isEmpty());
	}
	
	//단건조회
	//@Test
	public void deptInfo() {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(10);
		
		DeptVO findVO = deptMapper.selectDeptInfo(deptVO);
		assertEquals(findVO.getManagerId(), 200);
	}
	
	//등록
	//@Test
	public void deptInsert() {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(12);
		deptVO.setDepartmentName("ITTT");
		
		int result = deptMapper.insertDeptInfo(deptVO);
		
		//System.out.println(deptVO.getDepartmentId());
		assertEquals(result, 1);
	}
	
	//수정
	//@Test
	public void deptUpdate() {
		//1) 대상조회 (단건)
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(12);
		
		DeptVO findVO = deptMapper.selectDeptInfo(deptVO);
		System.out.println(findVO);

		//2) 정보수정
		findVO.setDepartmentName("ITTTT");
		int result = deptMapper.updateDeptInfo(findVO.getDepartmentId(), findVO);
		assertEquals(result, 1);
	}
	
	//삭제
	//@Test
	public void deptDelete() {
		int result = deptMapper.deleteDeptInfo(12);
		assertEquals(result, 1);
	}
	
	//전체조회★
	//@Test
	public void empList() {
		List<EmpVO> list = empMapper.selectEmpAll();
		assertTrue(!list.isEmpty()); 
		//내부에 데이터가 있는지 없는지 확인.
	}
	
	//단건조회★
	//@Test
	public void empInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals(findVO.getLastName(), "King");
	}
	
	//등록★
	//@Test
	public void empInsert() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("zczxc@gmail.com");
		empVO.setJobId("IT_PROG");
		
		int result = empMapper.insertEmpInfo(empVO);

		System.out.println(empVO.getEmployeeId());
		assertEquals(result, 1);
		
	}
	
	//수정★
	//@Test
	public void empUpdate() {
		//1) 대상조회 (단건)
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(206);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		System.out.println(findVO);
	
	
		//2) 정보수정
		findVO.setLastName("Kang");
		int result = empMapper.updateEmpInfo(findVO.getEmployeeId(), findVO);
		assertEquals(result, 1);
	}

	//삭제★	
	//@Test
	public void empDelete() {
		int result = empMapper.deleteEmpInfo(219);
		assertEquals(result, 1);
	}
}
