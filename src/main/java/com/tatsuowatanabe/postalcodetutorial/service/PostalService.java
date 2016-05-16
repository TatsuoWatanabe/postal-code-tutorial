package com.tatsuowatanabe.postalcodetutorial.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatsuowatanabe.postalcodetutorial.dto.PostalDto;
import com.tatsuowatanabe.postalcodetutorial.entity.Postal;
import com.tatsuowatanabe.postalcodetutorial.mapper.PostalMapper;

@Service
public class PostalService {
	@Autowired
	private PostalMapper postalMapper;
	
	public List<PostalDto> findWithPaging() {
		List<Postal> list = postalMapper.findWithPaging();
		List<PostalDto> resultList = convertToDto(list);
		return resultList;
	}
	
	private List<PostalDto> convertToDto(List<Postal> list) {
		List<PostalDto> resultList = list.stream().map(
			entity -> entity.toDto()
		).collect(Collectors.toList());
		
		return resultList;
	}
}
