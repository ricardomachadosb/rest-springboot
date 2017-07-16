package br.com.rest.converters.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rest.converters.BookConverter;
import br.com.rest.converters.CategoryConverter;
import br.com.rest.dtos.BookDTO;
import br.com.rest.models.BookModel;

@Component
public class DefaultBookConverter implements BookConverter{
	
	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public BookDTO convert(BookModel bookModel) {
		BookDTO bookDto = new BookDTO(bookModel.getTittle(), null);
		bookDto.setCategories(categoryConverter.convertAll(bookModel.getCategories()));
		
		return bookDto;
	}

}
