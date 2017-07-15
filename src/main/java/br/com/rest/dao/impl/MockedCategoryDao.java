package br.com.rest.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.rest.dao.CategoryDao;
import br.com.rest.exceptions.RestDataBaseRunTimeException;
import br.com.rest.models.CategoryModel;

@Repository
public class MockedCategoryDao implements CategoryDao{
	
	private Map<String, CategoryModel> dataBase = new HashMap<String, CategoryModel>();

	@Override
	public CategoryModel createCategory(String code, String tittle, String superCategoryCode) throws RestDataBaseRunTimeException{
		validateUniqueCategoryCode(code);
		
		CategoryModel category = new CategoryModel(code, tittle, getCategoryByCode(superCategoryCode));
		dataBase.put(code, category);
		
		return category;
	}
	
	/**
	 * @param categoryCode
	 * @throws RestDataBaseRunTimeException
	 */
	private void validateUniqueCategoryCode(String categoryCode) throws RestDataBaseRunTimeException{
		if(dataBase.get(categoryCode) != null){
			throw new RestDataBaseRunTimeException("Category code: \"" + categoryCode + "\" already in use"); 
		}
	}

	@Override
	public CategoryModel getCategoryByCode(String code) {
		return dataBase.get(code);
	}
}
