package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.domain.BoardDTO;
import com.test.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping("/board/list.do")
	public String list(Model model) {
		model.addAttribute("list",service.list());
		
		return "board/list";		
	}	
		@PreAuthorize("isAuthenticated()")
		@GetMapping("/board/add.do")
	   public String add() {
	      return "board/add";
	   }

	   @PostMapping("/board/addok.do")
	   public String addok(BoardDTO dto) {
		   int result = service.add(dto);
	      return "redirect:/board/list.do";
	   }
	   
	   @PreAuthorize("isAuthenticated()")
	   @GetMapping("/board/view.do")
	   public String view(Model model, String seq) {
	      BoardDTO dto = service.get(seq);
	      model.addAttribute("dto",dto);
	      return "board/view";
	   }
	   
	   @PreAuthorize("isAuthenticated()")
	   @GetMapping("/board/edit.do")
	   public String edit(Model model,String seq) {
		   model.addAttribute("seq",seq);
	      return "board/edit";	
	   }
	   
	   @PreAuthorize("isAuthenticated() and prinicipal.username==#{dto.id}")
	   @PostMapping("/board/editok.do")
	   public String editok(BoardDTO dto) {
	      int result = service.edit(dto);
	      return "redirect:/board/list.do";
	   }
	   
	   @PreAuthorize("isAuthenticated()")
	   @GetMapping("/board/del.do")
	   public String del(Model model, String seq) {
	      
		  model.addAttribute("seq",seq);
		  
	      return "board/del";
	   }
	   
	   @PostMapping("/board/delok.do")
	   public String delok(String seq) {
	      int result= service.del(seq);
	      return "redirect:/board/list.do";
	   }
	
	
	
}
