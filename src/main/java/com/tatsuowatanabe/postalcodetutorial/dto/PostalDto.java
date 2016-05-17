package com.tatsuowatanabe.postalcodetutorial.dto;

public class PostalDto {
	private Integer id;
	private String code;
	private String prefecture_name;
	private String prefecture_code;
	private String address1;
	private String address2;
	public final int limit = 300;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		if (code == null) return;
		this.code = escapeSQLSpecialChars(code.trim().replaceAll("-", ""));
	}

	public String getPrefecture_name() {
		return prefecture_name;
	}

	public void setPrefecture_name(String prefecture_name) {
		this.prefecture_name = prefecture_name;
	}

	public String getPrefecture_code() {
		return prefecture_code;
	}

	public void setPrefecture_code(String prefecture_code) {
		this.prefecture_code = prefecture_code;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	public String getFormatCode() {
		return this.code.replaceAll("(\\d{3})(\\d{4})", "$1-$2");
	}

	public String escapeSQLSpecialChars(String str) {
		return str.replaceAll("([%_])", "\\$1");
	}
}
