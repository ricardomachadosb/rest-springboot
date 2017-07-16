package br.com.rest.dao;

import java.util.Set;

import br.com.rest.models.SubscriberModel;

public interface SubscriberDao {
	
	public SubscriberModel createSubscriber(String email, Set<String> categoriesCodes);
	
	public SubscriberModel getSubscriberByEmail(String email);
}
