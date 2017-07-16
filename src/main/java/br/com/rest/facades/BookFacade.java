package br.com.rest.facades;

import java.util.Set;

import br.com.rest.dtos.BookDTO;

public interface BookFacade {
	public BookDTO createBook(String tittle, Set<String> categoriesCodes);
}
