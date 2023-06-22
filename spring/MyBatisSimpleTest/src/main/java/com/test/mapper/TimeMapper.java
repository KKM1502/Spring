package com.test.mapper;

import org.apache.ibatis.annotations.Select;

//SQL 담당자
public interface TimeMapper {

	@Select("select sysdate from dual")
	public String getTime();
	
	public String getTime2();
	
}
