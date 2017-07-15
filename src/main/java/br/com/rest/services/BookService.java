package br.com.rest.services;

import java.util.List;

import br.com.rest.models.BookModel;

public interface BookService {
	public BookModel createBook(String tittle, List<String> categoriesCodes);
}
