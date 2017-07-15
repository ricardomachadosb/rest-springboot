package br.com.rest.services.impl;

import java.util.ArrayList;
import java.util.List;

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
	private CategoryDao categoryDao;
	
	@Override
	public CategoryModel createCategory(String code, String tittle, String superCategoryCode) throws RestBusinessRunTimeException{
		validateArgs(code, tittle);
		
		CategoryModel newCategory = categoryDao.createCategory(code, tittle, superCategoryCode);
		
		return newCategory;
	}
	
	@Override
	public List<CategoryModel> getCategoriesByCodesForNewBook(List<String> categoriesCodes) throws RestBusinessRunTimeException{
		if(categoriesCodes == null || categoriesCodes.isEmpty()){
			return new ArrayList<CategoryModel>();
		}
		
		List<CategoryModel> categoriesToReturn = new ArrayList<CategoryModel>();
		
		for(String code: categoriesCodes){
			CategoryModel category = categoryDao.getCategoryByCode(code);
			
			if(category != null){
				validateDuplicateParentsCategory(categoriesToReturn, category.getCode());
				categoriesToReturn.add(category);
			}
		}
		return categoriesToReturn;
	}
	
	/**
	 * @param categoryList
	 * @param codeToValidade
	 */
	private void validateDuplicateParentsCategory(List<CategoryModel> categoryList, String codeToValidade) throws RestBusinessRunTimeException{ 
		for(CategoryModel c: categoryList){
			CategoryModel categoryToValidate = c;
			
			while(categoryToValidate != null){
				if(codeToValidade.equals(categoryToValidate.getCode())){
					throw new RestBusinessRunTimeException("Book's categories cannot belongs to the same category group");
				}
				categoryToValidate = categoryToValidate.getSuperCategory();
			}
		}
	}
	
	/**
	 * @param code
	 * @param tittle
	 * @throws RestBusinessRunTimeException
	 */
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
