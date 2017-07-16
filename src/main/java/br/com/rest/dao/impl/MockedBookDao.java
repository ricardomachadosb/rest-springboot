package br.com.rest.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.rest.dao.BookDao;
import br.com.rest.exceptions.RestDataBaseRunTimeException;
import br.com.rest.models.BookModel;
import br.com.rest.services.CategoryService;

@Repository
public class MockedBookDao implements BookDao{
	
	@Autowired
	private CategoryService categoryService;
	
	private Map<String, BookModel> dataBase = new HashMap<String, BookModel>();
	
	@Override
	public BookModel createBook(String tittle, Set<String> categoriesCode) throws RestDataBaseRunTimeException{
		validateUniqueBookTittle(tittle);
		
		BookModel bookModel = new BookModel(tittle, categoryService.getCategoriesByCodesForNewBook(categoriesCode));
		
		dataBase.put(tittle, bookModel);
		
		return bookModel;
	}
	
	/**
	 * @param categoryCode
	 * @throws RestDataBaseRunTimeException
	 */
	private void validateUniqueBookTittle(String tittle) throws RestDataBaseRunTimeException{
		if(dataBase.get(tittle) != null){
			throw new RestDataBaseRunTimeException("Book tittle: \"" + tittle + "\" already in use"); 
		}
	}
}
