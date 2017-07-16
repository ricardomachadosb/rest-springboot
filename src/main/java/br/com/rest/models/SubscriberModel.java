package br.com.rest.models;

import java.util.List;

public class SubscriberModel {
	
	private String email;
	
	private List<CategoryModel> categories;
	
	public SubscriberModel(String email, List<CategoryModel> categories) {
		this.email = email;
		this.categories = categories;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CategoryModel> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryModel> categories) {
		this.categories = categories;
	}
}
