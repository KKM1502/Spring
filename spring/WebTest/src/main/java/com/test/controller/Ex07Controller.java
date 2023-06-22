package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ex07Controller {
	//주로 500번대 에러
	@GetMapping("/ex07.do")
	public String ex07(Model model, @RequestParam(value="num", defaultValue = "10") int num){
		
		model.addAttribute("result",100/num);
		
		return "ex07";
	}
	
}
