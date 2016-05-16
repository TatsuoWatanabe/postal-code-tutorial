package com.tatsuowatanabe.postalcodetutorial.form.employee;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.tatsuowatanabe.postalcodetutorial.validator.annotation.Memo;


public class EmployeeListForm {
	@NotEmpty
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@NotNull
	@Min(18)
	@Digits(integer = 2, fraction = 0)
	private Integer age;
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Memo
	@Length(max=50)
	private String memo;
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
