package com.test.di05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardController {
	
	private BoardService service;
	
	@Autowired
	public BoardController(BoardService service) {
		this.service = service;
	}
	
	
	//의존 주입 도구
	//1. 생성자
	//2. Setter

	
	public void doget() {
		this.service.list();
	}
	public void doGet() {
		
		//의존 객체
		/*
		 * BoardService service = new BoardServiceImpl();
		 * 
		 * service.list();
		 */
		
		
		
		
		
		
	}
}
