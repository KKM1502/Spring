package com.test.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.domain.MyBatisDTO;
import com.test.persistence.MyBatisDAO;

@Controller
public class MyBatisController {

	//MyBatisController > (의존) > MyBatisDAO
	
	@Autowired
	private MyBatisDAO dao;
	
	@GetMapping("/m1.do")
	public String m1() {
		
		this.dao.m1();
		
		return "list";
	}
	@GetMapping("/add.do")
	public String add() {
		
		
		return "add";
	}
	
	@PostMapping("/addok.do")
	public String addok(MyBatisDTO dto) {
		
		this.dao.addok(dto);
		
		return "addok";
	}
	
	@GetMapping("/m2.do")
	public String m2(Model model, String seq) {
		
		int result = this.dao.m2(seq);
		model.addAttribute("result",result);
		
		return "list";
	}
	
	@GetMapping("/m3.do")
	public String m3() {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "호호호");
		map.put("address", "집");
		map.put("seq", "2");
		int result = this.dao.m3(map);
		return "list";
	}
	
	@GetMapping("/m4.do")
	public String m4(Model model) {
		
		int count= dao.m4();
		
		model.addAttribute("count",count);
		
		return "list";
	}

	@GetMapping("/m5.do")
	public String m5(Model model,String seq) {
		
		//다중값 반환(1행N열)
		//- select * from tblMyBatis where seq =1 
		
		MyBatisDTO dto= dao.m5(seq);
		
		model.addAttribute("dto",dto);
		
		return "list";
	}

	@GetMapping("/m6.do")
	public String m6(Model model) {
		
		//다중값 반환(N행1열)
		
		List<String> names= dao.m6();
		
		model.addAttribute("names",names);
		
		return "list";
	}

	@GetMapping("/m7.do")
	public String m7(Model model) {
		
		//다중값 반환(N행1열)
		
		List<MyBatisDTO> list= dao.m7();
		
		model.addAttribute("list",list);
		
		return "list";
	}

	@GetMapping("/m8.do")
	public String m8(Model model,String table) {
		
		//다중값 반환(N행1열)
		
		int count = dao.m8(table);
		
		model.addAttribute("count",count);
		
		return "list";
	}
	@GetMapping("/m9.do")
	public String m9(Model model, int age) {
		
		//다중값 반환(N행1열)
		List<MyBatisDTO> list = dao.m9(age);
		
		model.addAttribute("list",list);
		
		return "list";
	}
	@GetMapping("/m10.do")
	public String m10(Model model, String word) {
		
		//키워드 검색
		List<MyBatisDTO> list = dao.m10(word);
		
		model.addAttribute("list",list);
		
		return "list";
	}
	
	@GetMapping("/m11.do")
	public String m11(Model model) {
		
		//insert + dto
		//방금 insert한 Primary Key 를 가져오는 방법

		MyBatisDTO dto = new MyBatisDTO();
		
		dto.setName("장보고");
		dto.setAge("23");
		dto.setAddress("바닷가");
		dto.setGender("m");
		int result = dao.m11(dto);
		
		model.addAttribute("result",result);
		
		return "list";
	}
	@GetMapping("/m12.do")
	public String m12() {
	
		//MyBatis 동적 쿼리
		//- 동적 태그
		//- JSTL 유사
		
		//1. if
		//2. choose
		//3. trim
		//4. foreach
		
		return "list";
	}
	
}
