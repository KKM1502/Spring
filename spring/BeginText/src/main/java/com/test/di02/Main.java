package com.test.di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		
		
		//스프링 환경
		//- 객체 생성 ~ 소멸 > 스프링이 관리
		Pen p1 = new Pen();
		p1.write();
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("file:/src/main/java/com/test/di02/di02.xml"); 
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/di02/di02.xml"); 
		
		Pen p2 = (Pen)context.getBean("pen");
		p2.write();
		
		Brush b1 = (Brush)context.getBean("bursh");
		Hong hong = (Hong)context.getBean("hong");
		
	}
}
	