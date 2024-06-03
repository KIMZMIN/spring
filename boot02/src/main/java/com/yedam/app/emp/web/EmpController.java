package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller // => 사용자의 요청(EndPoint)이 들어오는 것에 대한 처리
			// : url + method => service => view
public class EmpController {
	//해당 컨트롤러에서 제공하는 서비스들 추가
	@Autowired
	EmpService empService;
	
	//GET  : 조회, 빈페이지(회원가입, 게시글:특정한 것을 요구하지 않는경우)
	//POST : 데이터 조작과 관련된(등록, 수정, 삭제)
	
	//전체조회 : GET
	@GetMapping("empList")
	public String empList(Model model) { //Model : Request와 Response를 합쳐놓은
		//1) 해당기능수행 -> Service
		List<EmpVO> list = empService.empList();
		//2) 클라이언트에 전달할 데이터 담기
		model.addAttribute("empList", list); 
		//변수표현식에서 쓸 이름? "empList"
		//페이지에서 사용할 이름/모델 : empList
		//3) 데이터를 출력할 페이지 결정
		return "emp/list";
		//이거 그냥 문자열임 -> 경로완성
		// 슬러시가 앞에 붙으면 안됨. return "/emp/list"; 오작동일으킴.
		// 경로 : classpath:/templates/    emp/list    .html(sub
		//         prefix			return  	 suffix
	}
	
	//단건조회 : GET
	@GetMapping("empInfo") //한건을 받을때, 커맨드객체(어노테이션을 안쓰는 객체를 말함.)
						   //커맨드 객체 => queryString(key=value&key=value...로 값을 받음)
	public String empInfo(EmpVO empVO, Model model) {
		//1) 해당기능수행 -> Service
		EmpVO findVO = empService.empInfo(empVO);
		
		//2) 클라이언트에 전달할 데이터 담기  값을 넘겨줌 // findVO (class)
		model.addAttribute("empInfo", findVO);
		//3) 데이터를 출력할 페이지 결정
		return "emp/info";
		//뷰 resolve에 저장된? 
		// prefix = "classpath:/templates/" suffix = ".html"
		// prefix + "emp/info" + suffix
		//"classpath:/templates/emp/info.html"
		// classpath => src/main/resources를 가리킴.
	}
	
	//등록 - 페이지 : GET (빈페이지 불러오기)
//	@GetMapping("empInsert")
//	public String empInsertForm() {
//		return "emp/insert";
//	}
	
	//등록 - 페이지 : GET (빈페이지 불러오기)
	@GetMapping("empInsert")
	public String empInsertForm(Model model) {
		model.addAttribute("empVO", new EmpVO());
		return "emp/insert";
	}
		
		
	//등록 - 처리 => Form 태그를 통한 submit
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		int eid = empService.empInsert(empVO);
		String url = null;
		if(eid > -1) {
			//정상적으로 등록된 경우
			url = "redirect:empInfo?employeeId="+eid;
		} else {
			//정상적으로 등록되지 않은 경우
			url = "redirect:empList";
		}
		return url;
	}
	
	//수정 - 페이지 : 단건 정보가 있어야함.
	@GetMapping("empUpdate")
	public String empUpdateForm(Integer employeeId, Model model) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		
		EmpVO findVO = empService.empInfo(empVO);
		model.addAttribute("empInfo", findVO);
		return "emp/update";
	}
	
	//수정 - 처리  : AJAX => QueryString
	//@PostMapping("empUpdate")
	@ResponseBody // => AJAX용
	public Map<String, Object> empUpdateAJAXQueryString(EmpVO empVO){
		return empService.empUpdate(empVO);
	}

	//수정 - 처리  : AJAX => JSON (@RequsetBody를 요구)
	@PostMapping("empUpdate")
	@ResponseBody // => AJAX용
	public Map<String, Object> empUpdateAjaxJson(@RequestBody EmpVO empVO){
		return empService.empUpdate(empVO);
	}	
	
	//삭제 - 처리
	@GetMapping("empDelete")
	public String empDelete(EmpVO empVO) {
		empService.empDelete(empVO);
		return "redirect:empList";
	}




}
