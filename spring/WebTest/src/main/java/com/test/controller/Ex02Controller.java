package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.persistence.SpringDAO;

public class Ex02Controller implements Controller {
	
	private SpringDAO dao;
	public Ex02Controller(SpringDAO dao) {
		this.dao = dao;
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ModelAndView mv = new ModelAndView("ex02");
		
		int count = dao.getCount();
		mv.addObject("count",count);
		
		return mv;
	}

	
}
