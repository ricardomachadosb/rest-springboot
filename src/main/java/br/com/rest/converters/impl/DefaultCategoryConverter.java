package br.com.rest.converters.impl;

import org.springframework.stereotype.Component;

import br.com.rest.converters.CategoryConverter;
import br.com.rest.dtos.CategoryDTO;
import br.com.rest.models.CategoryModel;

/**
 * @author ramachado
 *
 */
@Component
public class DefaultCategoryConverter implements CategoryConverter{

	@Override
	public CategoryDTO convert(CategoryModel category) {
		CategoryDTO categoryDTO = new CategoryDTO(category.getCode(), category.getTittle(), null);
		
		if(category.getSuperCategory() != null){
			categoryDTO.setSuperCategory(this.convert(category.getSuperCategory()));
		}
		
		return categoryDTO;
	}

}
