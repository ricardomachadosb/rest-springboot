package br.com.rest.dtos;

import java.util.List;

public class BookDTO {
	private String tittle;
	
	private List<CategoryDTO> categories;
	
	public BookDTO(String tittle, List<CategoryDTO> categories) {
		this.tittle = tittle;
		this.categories = categories;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}
}
