package com.test.persistence;

import org.springframework.stereotype.Repository;

@Repository
public class AOPDAOImpl implements AOPDAO{
	
	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("DAO.list");
	}
	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("DAO.add");
	}
	@Override
	public void view() {
		// TODO Auto-generated method stub
		System.out.println("DAO.view");
	}
	
}
