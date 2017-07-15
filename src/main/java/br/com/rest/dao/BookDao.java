package br.com.rest.dao;

import java.util.List;

import br.com.rest.exceptions.RestDataBaseRunTimeException;
import br.com.rest.models.BookModel;

public interface BookDao {

	public BookModel createBook(String tittle, List<String> categoriesCode) throws RestDataBaseRunTimeException;
	
}
