package com.tatsuowatanabe.postalcodetutorial.mapper;

import java.util.List;

import com.tatsuowatanabe.postalcodetutorial.dto.PostalDto;
import com.tatsuowatanabe.postalcodetutorial.entity.Postal;

public interface PostalMapper {

	List<Postal> findLimited(PostalDto dto);
	Integer foundRows(PostalDto dto);

}
