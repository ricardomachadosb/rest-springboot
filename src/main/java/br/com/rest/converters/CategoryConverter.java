package br.com.rest.converters;

import br.com.rest.dtos.CategoryDTO;
import br.com.rest.models.CategoryModel;

public interface CategoryConverter {
	public CategoryDTO convert(CategoryModel category);
}
