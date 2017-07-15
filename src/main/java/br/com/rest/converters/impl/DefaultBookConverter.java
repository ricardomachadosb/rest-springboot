package br.com.rest.converters.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rest.converters.BookConverter;
import br.com.rest.converters.CategoryConverter;
import br.com.rest.dtos.BookDTO;
import br.com.rest.dtos.CategoryDTO;
import br.com.rest.models.BookModel;
import br.com.rest.models.CategoryModel;

@Component
public class DefaultBookConverter implements BookConverter{
	
	@Autowired
	CategoryConverter categoryConverter;

	@Override
	public BookDTO convert(BookModel bookModel) {
		BookDTO bookDto = new BookDTO(bookModel.getTittle(), null);
		
		List<CategoryDTO> categories = new ArrayList<CategoryDTO>();
		List<CategoryModel> categoriesModel = bookModel.getCategories();
		if(categoriesModel != null && !categoriesModel.isEmpty()){
			for(CategoryModel cm: categoriesModel){
				categories.add(categoryConverter.convert(cm));
			}
		}
		bookDto.setCategories(categories);
		return bookDto;
	}

}
