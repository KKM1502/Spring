package com.test.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.domain.AddressDTO;
import com.test.domain.EmailDTO;
import com.test.mapper.AddressMapper;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressMapper mapper;
	
	
	@Override
	public void add(AddressDTO dto, String[] emailList) {
		
		mapper.add(dto);
		
		for (int i = 0; i < emailList.length; i++) {
			
			if(emailList[i].equals(""))continue;
			
			EmailDTO edto = new EmailDTO();
			edto.setPseq(dto.getSeq());
			edto.setEmail(emailList[i]);
			mapper.addEmail(edto);
		}
		
	}
	 @Override
	public List<AddressDTO> list() {
		 
		 //1. 직접 구현
			
			/*
			 * List<AddressDTO> list = mapper.list(); for(AddressDTO dto : list) {
			 * List<EmailDTO> elist = mapper.elist(dto.getSeq()); dto.setEmail(elist); }
			 */
			 
		 //2. MyBatis
			List<AddressDTO> list = mapper.list2(); 
		 
		 return list;
	}
}
