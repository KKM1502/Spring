package com.test.mapper;

import com.test.domain.MemberDTO;

public interface MemberMapper {

	MemberDTO read(String username);

}
