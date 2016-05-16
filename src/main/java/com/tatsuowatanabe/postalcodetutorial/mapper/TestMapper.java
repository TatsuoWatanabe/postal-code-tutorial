package com.tatsuowatanabe.postalcodetutorial.mapper;

import java.util.List;

import com.tatsuowatanabe.postalcodetutorial.dto.TestDto;
import com.tatsuowatanabe.postalcodetutorial.entity.Test;

public interface TestMapper {
	Test getTest(int id);
	List<Test> getTestAll();
	Test getTestByDto(TestDto dto);
	int insertTest(String name);
	int deleteTest(Integer id);
	int updateTest(TestDto dto);
}
