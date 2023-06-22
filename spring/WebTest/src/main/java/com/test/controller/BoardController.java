package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board/")
public class BoardController {

	//- "/web/list.do"
	//- "/web/add.do"
	//- "/web/addok.do"
	
	//- "/web/board/list.do"
	//- "/web/board/add.do"
	//- "/web/board/addok.do"

	
	@GetMapping("/list.do")
	public String list() {
		
		return "list";
	} 
	@RequestMapping(value="/add.do", method=RequestMethod.GET)
	public String add() {
		
		return "add";
	}
	@RequestMapping(value="/addok.do", method=RequestMethod.POST)
	public String addok() {
		
		return "addok";
	}
	@RequestMapping("/view.do")
	public String view() {
		
		return "view";
	}
	
	
}
