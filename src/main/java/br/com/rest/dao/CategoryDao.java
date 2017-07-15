package br.com.rest.dao;

import java.util.List;

import br.com.rest.exceptions.RestDataBaseRunTimeException;
import br.com.rest.models.CategoryModel;

/**
 * @author ramachado
 *
 */
public interface CategoryDao {
	
	public CategoryModel createCategory(String code, String tittle, String superCategoryCode) throws RestDataBaseRunTimeException;
	
	public CategoryModel getCategoryByCode(String code);
}
