package br.com.rest.facades;

import java.util.Set;

import br.com.rest.dtos.SubscriberDTO;

public interface SubscriberFacade {
	
	public SubscriberDTO createSubscriber(String email, Set<String> categoriesCodes);
	
}
