package br.com.rest.facades;

import java.util.List;
import java.util.Set;

import br.com.rest.dtos.NewsLetterDTO;
import br.com.rest.dtos.SubscriberDTO;

public interface SubscriberFacade {
	
	public SubscriberDTO createSubscriber(String email, Set<String> categoriesCodes);
	
	public List<NewsLetterDTO> getNewsLetterForAllSubscribers();
}
