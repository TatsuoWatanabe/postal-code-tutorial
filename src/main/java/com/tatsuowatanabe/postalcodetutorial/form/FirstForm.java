package com.tatsuowatanabe.postalcodetutorial.form;

public class FirstForm {
	private Integer id;
	public Integer getId() {
		return id;
	}
	public FirstForm setId(Integer id) {
		this.id = id;
		return this;
	}
	
	private String name;
	public String getName() {
		return name;
	}
	public FirstForm setName(String name) {
		this.name = name;
		return this;
	}	
	
	private String[] employees;
	public String[] getEmployees() {
		return employees;
	}
	public FirstForm setEmployees(String[] employees) {
		this.employees = employees;
		return this;
	}

}
