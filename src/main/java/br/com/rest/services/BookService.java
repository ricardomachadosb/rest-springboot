package br.com.rest.services;

import java.util.Set;

import br.com.rest.models.BookModel;

public interface BookService {
	public BookModel createBook(String tittle, Set<String> categoriesCodes);
}
