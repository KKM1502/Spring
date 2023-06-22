package com.test.di05;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("select * from tblBoard");
		
	}

}
