package br.com.rest.requests;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class CategoryRequestBody {
	
	@NotBlank
	@NotNull
	private String code;
	
	@NotBlank
	@NotNull
	private String tittle;
	
	private String superCategoryCode;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getSuperCategoryCode() {
		return superCategoryCode;
	}

	public void setSuperCategoryCode(String superCategoryCode) {
		this.superCategoryCode = superCategoryCode;
	}
	
}
