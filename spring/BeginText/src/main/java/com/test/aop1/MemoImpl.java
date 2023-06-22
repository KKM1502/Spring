package com.test.aop1;

import java.util.Calendar;

public class MemoImpl implements Memo {

	@Override
	public void add(String memo) {
		System.out.println("메모쓰기:" +memo);
		/*
		 * Calendar now = Calendar.getInstance();
		 * System.out.printf("[LOG][%tF %tT] 로그를 기록합니다.\n",now,now);
		 */
	}

	@Override
	public String read(int req) throws Exception {
		if(req<10) {
		System.out.println("메모읽기");}
		else {
			throw new Exception("존재하지 않는 메모");
		}
		return "홍길동";
	}

	@Override
	public boolean edit(int seq, String memo) {
		System.out.println("메모수정: "+ memo);
		return true;
	}

	@Override
	public boolean del(int seq) {
		System.out.println("메모삭제: "+ seq);
		return true;
	}

}
