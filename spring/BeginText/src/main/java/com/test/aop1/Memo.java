package com.test.aop1;

public interface Memo {

	//c
	void add(String memo);
	
	//r
	String read(int req) throws Exception;
	
	//u
	boolean edit(int seq, String memo);
	
	//d
	boolean del(int seq);
	
	
}
