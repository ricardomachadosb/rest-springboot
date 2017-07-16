package br.com.rest.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rest.dao.SubscriberDao;
import br.com.rest.exceptions.RestBusinessRunTimeException;
import br.com.rest.models.SubscriberModel;
import br.com.rest.services.SubscriberService;

@Service
public class DefaultSubscriberServiceImpl implements SubscriberService{
	
	@Autowired
	SubscriberDao subscriberDao;
	
	@Override
	public SubscriberModel createSubscriber(String email, Set<String> categoriesCodes) throws RestBusinessRunTimeException{
		validateArgs(email, categoriesCodes);
		return subscriberDao.createSubscriber(email, categoriesCodes);
	}
	
	@Override
	public List<SubscriberModel> getAllSubscribers() {
		return subscriberDao.getAllSubscribers();
	}
	
	/**
	 * @param code
	 * @param tittle
	 * @throws RestBusinessRunTimeException
	 */
	private void validateArgs(String email, Set<String> categoriesCodes) throws RestBusinessRunTimeException{
		boolean hasErrors = false;
		StringBuilder errorsMessages = new StringBuilder();
		
		if(email == null){
			hasErrors = true;
			errorsMessages.append("Email can't be null \n");
		}
		
		if(categoriesCodes == null || categoriesCodes.isEmpty()){
			hasErrors = true;
			errorsMessages.append("CategoriesCodes can't be null \n");
		}
		
		if(hasErrors){
			throw new RestBusinessRunTimeException(errorsMessages.toString());
		}
	}
}
