package com.test.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.domain.SpringDTO;

@Controller
public class Ex06Controller {

	// 요청 메소드의 반환 자료형

	// 1. String
	// - JSP파일 이름

	// 2. void
	// - 요청 주소와 동일한 이름은 JSP 페이지를 자동으로 호출한다.
	/*
	 * @GetMapping("/ex06.do") public void test() {
	 * 
	 * }
	 */

	// 3. String + 키워드
	// - 요청 주소와 동일한 이름은 JSP 페이지를 자동으로 호출한다.
	/*
	 * @GetMapping("/ex06.do") public String test(RedirectAttributes rttr) {
	 * 
	 * String seq = "5"; String type = "1";
	 * 
	 * rttr.addAttribute("seq",seq); rttr.addAttribute("type",type);
	 * //response.sendRedirect() return "redirect:/ex05.do?seq=5&type=1"; return
	 * "redirect:/ex05.do"; }
	 */
	
	//4. 객체
	//JSON 반환값 생성하는 어노테이션
	
	@GetMapping("/ex06.do")
	public @ResponseBody java.util.List<SpringDTO> test() {
		
		java.util.List<SpringDTO> list = new ArrayList<SpringDTO>();
		SpringDTO dto = new SpringDTO();
		
		dto.setName("홍길동");
		dto.setAge("20");
		dto.setAddress("서울시");
		
		list.add(dto);
		
		return list;
	}
	
}
