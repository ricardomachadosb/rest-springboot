package br.com.rest.dtos;

import java.util.List;

public class SubscriberDTO {
	
	private String email;
	
	private List<CategoryDTO> categories;
	
	public SubscriberDTO(String email, List<CategoryDTO> categories) {
		this.email = email;
		this.categories = categories;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}
	
}
