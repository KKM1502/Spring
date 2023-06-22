package com.test.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//보조 업무 객체
@Component
@Aspect
public class Log {
	/*
	 * @After("execution(* add(..))") public void m1() {
	 * System.out.println("[보조]기록을 남깁니다."); }
	 */
	
	@Pointcut("execution(* add(..))")
	public void pc1() {
		
	}
	 @After("pc1()") 
	 public void m1() {
		 System.out.println("[보조]기록을 남깁니다."); 
	}
}
