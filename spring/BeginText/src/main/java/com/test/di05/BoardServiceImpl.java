package com.test.di05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardDAO dao;
	
	@Autowired
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}

	public void list() {
		/*
		 * // TODO Auto-generated method stub BoardDAO dao = new BoardDAOImpl();
		 * dao.list();
		 */
		this.dao.list();
		
	}



	
}
