package br.com.rest.models;

import java.util.List;

public class BookModel {
	
	private String tittle;
	
	private List<CategoryModel> categories;
	
	public BookModel(String tittle, List<CategoryModel> categories) {
		this.tittle = tittle;
		this.categories = categories;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public List<CategoryModel> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryModel> categories) {
		this.categories = categories;
	}
	
	
}
