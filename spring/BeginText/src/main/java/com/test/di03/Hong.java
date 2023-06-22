package com.test.di03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

//@Component: <bean> 태그와 동일한 역할
// > 스프링에서 관리하는 객체

//@Autowired : 의존주입 어노테이션
//> 아래에 있는 대상에 객체를 주입해주세요~.

@Component
public class Hong {
	
	@Autowired
	private Pen pen;
	
	
	/*
	 * @Autowired public Hong(Pen pen) { this.pen=pen; }
	 */
	public void run() {
		pen.write();
	}
	
}
