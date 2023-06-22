package com.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j2;


@ControllerAdvice //에러 발생시 이 클래스 호출
public class CommonExceptionAdvice {

	@ExceptionHandler(Exception.class)//try catch 에서 e
	public String except(Exception e, Model model) {
		
		System.out.println("예외발생");
		
		model.addAttribute("code","A001");
		model.addAttribute("e",e);
		
		return "error";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String notfound() {
		
		return "notfound";
	}
}
