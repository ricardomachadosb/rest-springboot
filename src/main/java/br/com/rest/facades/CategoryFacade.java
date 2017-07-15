package br.com.rest.facades;

import br.com.rest.dtos.CategoryDTO;

public interface CategoryFacade {
	
	/**
	 * @param code
	 * @param tittle
	 * @param superCategoryCode
	 * @return
	 */
	public CategoryDTO createCategory(String code, String tittle, String superCategoryCode);
	
}
