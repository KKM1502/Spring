package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex04.do")
public class Ex04Controller {

	@RequestMapping
	public String ex04() {
		
		return "ex04";
	}
}
