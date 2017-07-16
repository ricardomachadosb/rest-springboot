package br.com.rest.converters;

import java.util.List;

import br.com.rest.dtos.CategoryDTO;
import br.com.rest.models.CategoryModel;

public interface CategoryConverter {
	public CategoryDTO convert(CategoryModel category);
	
	public List<CategoryDTO> convertAll(List<CategoryModel> categories);
}
