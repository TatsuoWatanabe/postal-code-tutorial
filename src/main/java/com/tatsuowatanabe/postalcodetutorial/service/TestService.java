package com.tatsuowatanabe.postalcodetutorial.service;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatsuowatanabe.postalcodetutorial.dto.TestDto;
import com.tatsuowatanabe.postalcodetutorial.entity.Test;
import com.tatsuowatanabe.postalcodetutorial.mapper.TestMapper;

@Service
public class TestService {
	@Autowired
	private TestMapper testMapper;

	public TestDto getTest(Integer id) {
		TestDto dto = new TestDto();
		Test entity = testMapper.getTest(id);
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public List<TestDto> getTestAll() {
		List<Test> testList = testMapper.getTestAll();
		List<TestDto> resultList = convertToDto(testList);
		return resultList;
	}

	private List<TestDto> convertToDto(List<Test> testList) {
		List<TestDto> resultList = testList.stream().map(entity -> {
			TestDto dto = new TestDto();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}).collect(Collectors.toList());
		
		return resultList;
	}

	public TestDto getTestByDto(TestDto dto) {
		Test entity = testMapper.getTestByDto(dto);
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public int insertTest(String name) {
		int count = testMapper.insertTest(name);
		return count;
	}

	public int deleteTest(Integer id) {
		int count = testMapper.deleteTest(id);
		return count;
	}

	public int updateTest(TestDto dto) {
	    int count = testMapper.updateTest(dto);
	    return count;
	}

}
