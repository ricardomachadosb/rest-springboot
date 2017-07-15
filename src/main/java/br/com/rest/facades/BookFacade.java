package br.com.rest.facades;

import java.util.List;

import br.com.rest.dtos.BookDTO;

public interface BookFacade {
	public BookDTO createBook(String tittle, List<String> categoriesCodes);
}
