package com.yedam.app.dept.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;
import com.yedam.app.emp.service.EmpVO;

public class DeptController {
	@Autowired
	DeptService deptService;

	//전체조회
	@GetMapping("deptList")
	public String deptList(Model model) {
		List<DeptVO> list = deptService.deptList();
		 
		model.addAttribute("deptList", list);
		return "dept/list";
	}
	
	//단건조회
	@GetMapping("deptInfo")
	public String deptInfo(DeptVO deptVO, Model model) {
		DeptVO findVO = new DeptVO();
		model.addAttribute("deptInfo", findVO);
		return "dept/info";
	}
	
	//등록 - 페이지
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/insert";
	}
	
	//등록 - 처리
	@PostMapping("deptInsert")
	public String deptInsertProcess(DeptVO deptVO) {
		int deptId = deptService.deptInset(deptVO);
		String url = null;
		if(deptId > -1) {
			url = "redirect:deptInfo?departmentId=" + deptId;
		}else {
			url = "redirect:deptList";
		}
		return url;
	}
	
	//수정 - 페이지
	@GetMapping("deptUpdate")
	public String deptUpdateForm(Integer departmentId, Model model) {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(departmentId);
		
		DeptVO findVO = deptService.deptInfo(deptVO);
		model.addAttribute("deptInfo", findVO);
		
		return "dept/update";
	}
	
	//수정 - 처리
	@PostMapping("deptUpdate")
	@ResponseBody // => AJAX용
	public Map<String, Object> empUpdateAJAXQueryString(DeptVO deptVO){
		return deptService.deptUpdate(deptVO);
	}
	
	//삭제
	@GetMapping("deptDelete")
	public String deptDelete(DeptVO deptVO) {
		deptService.deptDelete(deptVO);
		return "redirect:deptList";
	}
}
