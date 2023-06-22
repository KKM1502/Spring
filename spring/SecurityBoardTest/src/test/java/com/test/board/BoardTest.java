package com.test.board;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.test.domain.BoardDTO;
import com.test.service.BoardService;

import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardTest {

	@Autowired
	private BoardService service;

	/*
	 * @Test public void testAdd() { BoardDTO dto = new BoardDTO();
	 * dto.setId("dog"); dto.setSubject("글쓰기 테스트"); dto.setContent("내용"); int result
	 * =service.add(dto); log.info(result); }
	 * 
	 * @Test public void testList() { List<BoardDTO> list =service.list();
	 * for(BoardDTO dto : list) { log.info(dto); } }
	 * 
	 * @Test public void testGet() { BoardDTO dto = service.get("1"); log.info(dto);
	 * }
	 * 
	 * @Test public void testEdit() { BoardDTO dto =new BoardDTO(); dto.setSeq("1");
	 * dto.setSubject("제목"); dto.setContent("수정"); log.info(service.edit(dto)); }
	 */
	@Test
	public void testDel() {
		log.info(service.del("1"));
		log.info(service.list());
	}
}
