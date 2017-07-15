package br.com.rest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rest.dao.BookDao;
import br.com.rest.exceptions.RestBusinessRunTimeException;
import br.com.rest.models.BookModel;
import br.com.rest.services.BookService;

@Service
public class DefaultBookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Override
	public BookModel createBook(String tittle, List<String> categoriesCodes) {
		validateArgs(tittle, categoriesCodes);
		
		BookModel bookModel = bookDao.createBook(tittle, categoriesCodes);
		
		return bookModel;
	}
	
	/**
	 * @param code
	 * @param tittle
	 * @throws RestBusinessRunTimeException
	 */
	private void validateArgs(String tittle, List<String> categoriesCodes) throws RestBusinessRunTimeException{
		boolean hasErrors = false;
		StringBuilder errorsMessages = new StringBuilder();
		
		if(tittle == null){
			hasErrors = true;
			errorsMessages.append("tittle can't be null \n");
		}
		
		if(categoriesCodes == null || categoriesCodes.isEmpty()){
			hasErrors = true;
			errorsMessages.append("categoriesCodes can't be null \n");
		}
		
		if(hasErrors){
			throw new RestBusinessRunTimeException(errorsMessages.toString());
		}
	}

}
