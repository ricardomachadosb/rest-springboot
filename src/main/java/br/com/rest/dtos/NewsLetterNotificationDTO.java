package br.com.rest.dtos;

import java.util.List;

public class NewsLetterNotificationDTO {
	private String book;
	private List<List<String>> categoryPaths;
	
	public NewsLetterNotificationDTO(String book, List<List<String>> categoryPaths) {
		this.book = book;
		this.categoryPaths = categoryPaths;
	}
	
	public NewsLetterNotificationDTO() {}
	
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public List<List<String>> getCategoryPaths() {
		return categoryPaths;
	}
	public void setCategoryPaths(List<List<String>> categoryPaths) {
		this.categoryPaths = categoryPaths;
	}
	
}
