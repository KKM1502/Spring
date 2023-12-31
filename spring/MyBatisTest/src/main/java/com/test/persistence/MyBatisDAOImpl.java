package com.test.persistence;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.domain.MyBatisDTO;

//@Component
@Repository
public class MyBatisDAOImpl implements MyBatisDAO {
	
	//MyBatisDAO > (의존) > SqlSessionTemplate
	
	@Autowired
	private SqlSessionTemplate template;
	
	public void test() {
		System.out.println(this.template == null);
	}

	@Override
	public void m1() {
		
		//MyBatis(SqlSessionTemplate) > XML 기반 작업(XML Mapper)
		
		/*
			
			1. executeUpdate()
				- template.insert()
				- template.update()
				- template.delete()
			
			2. executeQuery()
				- template.selectOne()  > 결과셋 레코드 1개 
										> if (rs.next()) {}
										
				- template.selectList() > 결과셋 레코드 N개
										> while (rs.next()) {}
		
		*/
		
		//this.template.insert("매퍼 네임스페이스.쿼리 ID");
		this.template.insert("mybatis.m1");
		
	}//m1
	
	@Override
	public void addok(MyBatisDTO dto) {
		this.template.insert("mybatis.add",dto);
	}
	
	@Override
	public int m2(String seq) {
		
		return this.template.delete("mybatis.m2",seq);
		
	}
	
	@Override
	public int m3(Map<String,String> map) {
		
		return this.template.update("mybatis.m3",map);
		
	}
	 
	@Override
	public int m4() {
		
		return this.template.selectOne("mybatis.m4");
	}
	
	@Override
	public MyBatisDTO m5(String seq) {
		return this.template.selectOne("mybatis.m5",seq);
	}
	
	@Override
	public List<String> m6() {
		return this.template.selectList("mybatis.m6");
	}
	
	@Override
	public List<MyBatisDTO> m7() {
		
		return this.template.selectList("mybatis.m7");
	}
	
	@Override
	public int m8(String table) {
		
		return this.template.selectOne("mybatis.m8",table);
	}
		
	@Override
	public List<MyBatisDTO> m9(int age) {
		return this.template.selectList("mybatis.m9",age);
	}
	
	@Override
	public List<MyBatisDTO> m10(String word) {
		return this.template.selectList("mybatis.m10",word);
	}
	@Override
	public int m11(MyBatisDTO dto) {
		int result= this.template.insert("mybatis.m11",dto);
		System.out.println(dto.getSeq());
		return result;
	}
	
}

















