package com.yedam.app.rent.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.rent.service.RentService;
import com.yedam.app.rent.service.RentVO;

@Controller
public class RentController {
	@Autowired
	RentService rentService;
	
	@GetMapping("rentList")
	public String rentList(Model model) {
		List<RentVO> list = rentService.rentList();
		model.addAttribute("rent", list);
		
		return "rent/rentList";
	}
}
