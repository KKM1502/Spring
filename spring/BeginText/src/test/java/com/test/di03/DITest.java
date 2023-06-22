package com.test.di03;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

//테스트용 자바 클래스 > JUnit

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DITest {
	private Hong hong;
	
	@Autowired
	public void setHong(Hong hong) {
		this.hong=hong;
	}
	@Test
	public void testExsist() {
		assertNotNull(hong);
		
		hong.run();
		
	}
}
