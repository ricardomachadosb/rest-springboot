package br.com.rest.dao;

import java.util.Set;

import br.com.rest.exceptions.RestDataBaseRunTimeException;
import br.com.rest.models.BookModel;

public interface BookDao {

	public BookModel createBook(String tittle, Set<String> categoriesCode) throws RestDataBaseRunTimeException;
	
}
