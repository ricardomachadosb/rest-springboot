package br.com.rest.facades.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rest.converters.BookConverter;
import br.com.rest.dtos.BookDTO;
import br.com.rest.facades.BookFacade;
import br.com.rest.models.BookModel;
import br.com.rest.services.BookService;

@Component
public class DefaultBookFacadeImpl implements BookFacade{
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookConverter bookConverter;

	@Override
	public BookDTO createBook(String tittle, List<String> categoriesCodes) {
		BookModel bookModel = bookService.createBook(tittle, categoriesCodes);
		BookDTO bookDto = bookConverter.convert(bookModel);
		return bookDto;
	}
	
	
	
}
