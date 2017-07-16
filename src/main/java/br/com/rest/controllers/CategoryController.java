package br.com.rest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rest.dtos.CategoryDTO;
import br.com.rest.facades.CategoryFacade;
import br.com.rest.requests.CategoryRequestBody;


@RestController
public class CategoryController {
	
	@Autowired
	private CategoryFacade categoryFacade;
	
	@RequestMapping(path="/categories", method=RequestMethod.POST)
	public CategoryDTO createCategory(@Valid @RequestBody CategoryRequestBody request){
		
		return categoryFacade.createCategory(request.getCode(), request.getTittle(), request.getSuperCategoryCode());
	}
}
