package br.com.rest.converters.impl;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<CategoryDTO> convertAll(List<CategoryModel> categories) {
		List<CategoryDTO> categoriesDto = new ArrayList<CategoryDTO>();
		
		if(categories != null && !categories.isEmpty()){
			for(CategoryModel cm: categories){
				categoriesDto.add(this.convert(cm));
			}
		}
		
		return categoriesDto;
	}

}
