package br.com.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rest.dtos.CategoryDTO;
import br.com.rest.facades.CategoryFacade;


@RestController
public class CategoryController {
	
	@Autowired
	CategoryFacade categoryFacade;
	
	@RequestMapping(path="/categories", method=RequestMethod.POST)
	public CategoryDTO createCategory(@RequestParam(value="code", required=true) String code,
			@RequestParam(value="tittle", required=true) String tittle,
			@RequestParam(value="superCategoryCode", required=false) String superCategoryCode){
		
		return categoryFacade.createCategory(code, tittle, superCategoryCode);
	}
}
