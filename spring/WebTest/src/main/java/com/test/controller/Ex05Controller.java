package com.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.domain.SpringDTO;

@Controller
public class Ex05Controller {

	
		@GetMapping("/ex05.do")
		public String ex05() {
			
			return "ex05";
		}
		
		/*
		 * //데이터 수신 //request.getParameter("")
		 * 
		 * @PostMapping("/ex05ok.do") public String ex05ok(HttpServletRequest req) {
		 * 
		 * String data = req.getParameter("data"); req.setAttribute("data", data);
		 * return "ex05ok"; }
		 * 
		 */
		
		/*
		 * @PostMapping("/ex05ok.do") public String ex05ok(@RequestParam("data") String
		 * data, Model model) {
		 * 
		 * 
		 * //ModelAndView > Model
		 * 
		 * model.addAttribute("data",data);
		 * 
		 * return "ex05ok"; }
		 */
		/*
		 * @PostMapping("/ex05ok.do") public String ex05ok(Model model, String data) {
		 * 
		 * //@RequestParam("data") >> 생락 가능ㅌ //ModelAndView > Model
		 * 
		 * model.addAttribute("data",data);
		 * 
		 * return "ex05ok"; }
		 */
		/*
		 * @PostMapping("/ex05ok.do") public String ex05ok(Model model,String
		 * name,String age, String address) { SpringDTO dto = new SpringDTO();
		 * 
		 * dto.setAddress(address); dto.setName(name); dto.setAge(age);
		 * 
		 * model.addAttribute("dto",dto);
		 * 
		 * return "ex05ok"; }
		 */
		
		/*
		 * @PostMapping("/ex05ok.do") public String ex05ok(Model model, SpringDTO dto,
		 * String seq) {
		 * 
		 * model.addAttribute("dto",dto);
		 * 
		 * return "ex05ok"; }
		 */
		
		@PostMapping("/ex05ok.do")
		public String ex05ok(Model model, String[] cb) {
					
			model.addAttribute("cb",cb);
			
			return "ex05ok";
		}
		
}
