package br.com.rest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rest.dao.CategoryDao;
import br.com.rest.exceptions.RestBusinessRunTimeException;
import br.com.rest.models.CategoryModel;
import br.com.rest.services.CategoryService;

/**
 * @author ramachado
 *
 */
@Service
public class DefaultCategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public CategoryModel createCategory(String code, String tittle, String superCategoryCode) throws RestBusinessRunTimeException{
		validateArgs(code, tittle);
		
		CategoryModel newCategory = categoryDao.createCategory(code, tittle, superCategoryCode);
		
		return newCategory;
	}
	
	private void validateArgs(String code, String tittle) throws RestBusinessRunTimeException{
		boolean hasErrors = false;
		StringBuilder errorsMessages = new StringBuilder();
		
		if(code == null){
			hasErrors = true;
			errorsMessages.append("Code can't be null \n");
		}
		
		if(tittle == null){
			hasErrors = true;
			errorsMessages.append("Tittle can't be null \n");
		}
		
		if(hasErrors){
			throw new RestBusinessRunTimeException(errorsMessages.toString());
		}
	}

}
