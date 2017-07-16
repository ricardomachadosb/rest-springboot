package br.com.rest.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.rest.dao.SubscriberDao;
import br.com.rest.models.CategoryModel;
import br.com.rest.models.SubscriberModel;
import br.com.rest.services.CategoryService;

@Repository
public class MockedSubscriberDaoImpl implements SubscriberDao{
	
	@Autowired
	CategoryService categoryService;
	
	private Map<String, SubscriberModel> dataBase = new HashMap<String, SubscriberModel>();
	
	@Override
	public SubscriberModel createSubscriber(String email, Set<String> categoriesCodes) {
		SubscriberModel subs = this.getSubscriberByEmail(email);
		
		if(subs == null){
			subs = new SubscriberModel(email, null);
		}
		
		subs.setCategories(categoryService.getCategoriesByCodes(categoriesCodes));
		
		dataBase.put(email, subs);
		
		return subs;
	}


	@Override
	public SubscriberModel getSubscriberByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
