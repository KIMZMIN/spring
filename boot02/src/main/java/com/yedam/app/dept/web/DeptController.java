package com.yedam.app.dept.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;
import com.yedam.app.emp.service.EmpVO;

@Controller
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
		DeptVO findVO = deptService.deptInfo(deptVO);
		model.addAttribute("deptInfo", findVO);
		return "dept/info";
	}
	
	//등록 - 페이지
	@GetMapping("deptInsert")
	public String deptInsertForm(Model model) {
		model.addAttribute("deptVO", new DeptVO());
		return "dept/insert";
	}
	
	//등록 - 처리
	@PostMapping("deptInsert")
	public String deptInsertProcess(DeptVO deptVO) {
		int deptId = deptService.deptInsert(deptVO);
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
//	@PostMapping("deptUpdate")
//	@ResponseBody
//	public Map<String, Object> deptUpdateAJAXQueryString(DeptVO deptVO){
//		return deptService.deptUpdate(deptVO);
//	}
	@PostMapping("deptUpdate")
	@ResponseBody
	public Map<String, Object> deptUpdateAjaxJson(@RequestBody DeptVO deptVO){
		return deptService.deptUpdate(deptVO);
	}
	
	//삭제
	@GetMapping("deptDelete")
	public String deptDelete(DeptVO deptVO) {
		deptService.deptDelete(deptVO);
		return "redirect:deptList";
	}
}
