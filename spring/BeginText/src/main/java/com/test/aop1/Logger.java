package com.test.aop1;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {

	//보조 업무 구현
	public void log() {
		Calendar now = Calendar.getInstance();
		System.out.printf("[LOG][%tF %tT] 로그를 기록합니다.\n",now,now);
	}
	public void time(ProceedingJoinPoint jp) {
		long begin = System.nanoTime();
		System.out.printf("[LOG]로그 기록을 실행합니다.\n");
		
		//주 업무 실행s
		//- 글쓰기 > 주 업무 객체의 가상 객체 참조
		try {
			jp.proceed(); //현재 실행되는 주 업무 메소드
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end=System.nanoTime();
		System.out.printf("[LOG]로그 기록을 종료합니다.\n");
		System.out.printf("[LOG]소요시간 %,dns\n",end-begin);
	}
	
	public void history(Object memo) {
		System.out.println(" [LOG]로그 읽기 기록:"+memo);
		
	}
	public void check(Exception e) {
		System.out.println(" [LOG]예외발생:"+e);
		
	}
}
