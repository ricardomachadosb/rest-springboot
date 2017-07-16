package br.com.rest.services;

import java.util.List;
import java.util.Set;

import br.com.rest.exceptions.RestBusinessRunTimeException;
import br.com.rest.models.SubscriberModel;

public interface SubscriberService {
	public SubscriberModel createSubscriber(String email, Set<String> categoriesCodes) throws RestBusinessRunTimeException;
	
	public List<SubscriberModel> getAllSubscribers();

}
