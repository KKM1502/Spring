package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//JSP Model2 > 발전 > Spring MVC

//서블릿 역할

public class Ex01Controller implements Controller{

	//요청 메소드
	//doGet/doPost ==handleRequest
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//RequestDispatcher > forward()
		
		//Model > 데이터 전송
		//View > JSP
		ModelAndView mv = new ModelAndView();
		
		//mv.setViewName("/WEB-INF/views/ex01.jsp");
		mv.setViewName("ex01");
		
		mv.addObject("name","아무개");
		
		
		//request.setAttribute("name", "홍길동"); > 비권장
		
		return mv;
	}

	
	
	
}
