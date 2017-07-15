package br.com.rest.facades.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rest.converters.CategoryConverter;
import br.com.rest.dtos.CategoryDTO;
import br.com.rest.facades.CategoryFacade;
import br.com.rest.models.CategoryModel;
import br.com.rest.services.CategoryService;

@Component
public class DefaultCategoryFacadeImpl implements CategoryFacade{
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CategoryConverter categoryConverter;

	@Override
	public CategoryDTO createCategory(String code, String tittle, String superCategoryCode) {
		CategoryModel categoryModel = categoryService.createCategory(code, tittle, superCategoryCode);
		CategoryDTO dto = categoryConverter.convert(categoryModel);
		
		return dto;
	}

}
