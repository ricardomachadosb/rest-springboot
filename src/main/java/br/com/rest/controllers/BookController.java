package br.com.rest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rest.dtos.BookDTO;
import br.com.rest.facades.BookFacade;
import br.com.rest.requests.BookRequestBody;

@RestController
public class BookController {
	
	@Autowired
	private BookFacade bookFacade;
	
	@RequestMapping(path="/books", method=RequestMethod.POST)
	public BookDTO createCategory(@Valid @RequestBody BookRequestBody request){
		
		return bookFacade.createBook(request.getTittle(), request.getCategoryCodes());
	}
}
