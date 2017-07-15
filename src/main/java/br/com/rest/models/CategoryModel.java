package br.com.rest.models;

public class CategoryModel {
	
	private String code;
	
	private String tittle;

	private CategoryModel superCategory;
	
	public CategoryModel(String code, String tittle, CategoryModel superCategory) {
		this.code = code;
		this.tittle = tittle;
		this.superCategory = superCategory;
	}

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

	public CategoryModel getSuperCategory() {
		return superCategory;
	}

	public void setSuperCategory(CategoryModel superCategory) {
		this.superCategory = superCategory;
	}
} 
