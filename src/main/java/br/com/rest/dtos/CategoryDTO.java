package br.com.rest.dtos;

public class CategoryDTO {
	private String code;
	
	private String tittle;

	private CategoryDTO superCategory;
	
	public CategoryDTO(String code, String tittle, CategoryDTO superCategory) {
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

	public CategoryDTO getSuperCategory() {
		return superCategory;
	}

	public void setSuperCategory(CategoryDTO superCategory) {
		this.superCategory = superCategory;
	}
}
