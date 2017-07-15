package br.com.rest.converters;

import br.com.rest.dtos.BookDTO;
import br.com.rest.models.BookModel;

public interface BookConverter {
	public BookDTO convert(BookModel bookModel);
}
