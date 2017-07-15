package br.com.rest.services;

import br.com.rest.exceptions.RestBusinessRunTimeException;
import br.com.rest.models.CategoryModel;

/**
 * @author ramachado
 *
 */
public interface CategoryService {
	
	public CategoryModel createCategory(String code, String tittle, String superCategoryCode) throws RestBusinessRunTimeException;

}
