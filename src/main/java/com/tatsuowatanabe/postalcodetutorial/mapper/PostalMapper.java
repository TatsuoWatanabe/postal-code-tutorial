package com.tatsuowatanabe.postalcodetutorial.mapper;

import java.util.List;

import com.tatsuowatanabe.postalcodetutorial.dto.*;
import com.tatsuowatanabe.postalcodetutorial.entity.*;

public interface PostalMapper {
	List<Postal> findLimited(PostalDto dto);
	Integer foundRows(PostalDto dto);
	List<Prefecture> findPrefectures();
}
