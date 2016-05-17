package com.tatsuowatanabe.postalcodetutorial.entity;

import org.springframework.beans.BeanUtils;

import com.tatsuowatanabe.postalcodetutorial.dto.PrefectureDto;

public class Prefecture {
	private Integer code;
	private String prefectureName;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getPrefectureName() {
		return prefectureName;
	}

	public void setPrefectureName(String prefectureName) {
		this.prefectureName = prefectureName;
	}

	public PrefectureDto toDto() {
		PrefectureDto dto = new PrefectureDto();
		BeanUtils.copyProperties(this, dto);
		return dto;
	}
}
