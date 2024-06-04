package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@RestController //@Controller + 모든 메소드에 @ResponseBody를 적용
				//@ResponseBody : AJAX ; 데이터를 바로 응답해줌?
public class EmpRestController {
	@Autowired
	EmpService empService;
	
	//REST 방식 => Model 안씀.
	//전체조회 : GET => emps
	@GetMapping("emps")
	public List<EmpVO> empList(){
		return empService.empList();
		//서비스가 가져온 걸 그대로 클라이언트에게 전달.
		//모델에 뭔가 담을필요, 페이지를 지정할 필요가 없음.
	}
	
	//단건조회 : GET => emps/100
	// 이름이 같을경우
/*	@GetMapping("emps/{employeeId}")
	public EmpVO empInfo(@PathVariable Integer employeeId) { 
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		return empService.empInfo(empVO);
	}
*/
	// 이름이 다를경우
	@GetMapping("emps/{id}")
	public EmpVO empInfo(@PathVariable(name="id")Integer employeeId) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		return empService.empInfo(empVO);
	}
	
	//등록 : POST => emps
	@PostMapping("emps")  //@RequestBody : JSON ; POST, PUT 일때 RequestBody를 씀.
	public int empInsert(@RequestBody EmpVO empVO) {
		return empService.empInsert(empVO);
	}
	
	//수정 : PUT => emps/100
	@PutMapping("emps/{employeeId}")
	public Map<String, Object> empUpdate(@PathVariable Integer employeeId, //경로를 통해서 수정할 Target(대상)을 가져오고
										 @RequestBody EmpVO empVO){ //수정할 정보는 JSON포맷으로 받음
		empVO.setEmployeeId(employeeId);
		return empService.empUpdate(empVO);
	}
	
	
	//삭제 : DELETE => emps/100
	@DeleteMapping("emps/{employeeId}")
	public Map<String, Object> empDelete(@PathVariable Integer employeeId){
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		return empService.empDelete(empVO);
	}
	
}
