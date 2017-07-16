package br.com.rest.facades.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rest.converters.SubscriberConverter;
import br.com.rest.dtos.SubscriberDTO;
import br.com.rest.facades.SubscriberFacade;
import br.com.rest.models.SubscriberModel;
import br.com.rest.services.SubscriberService;

@Component
public class DefaultSubscriberFacadeImpl implements SubscriberFacade{
	
	@Autowired
	private SubscriberConverter subscriberConverter;
	
	@Autowired
	private SubscriberService subscriberService;
	
	@Override
	public SubscriberDTO createSubscriber(String email, Set<String> categoriesCodes) {
		SubscriberModel subscriberModel = subscriberService.createSubscriber(email, categoriesCodes);
		SubscriberDTO subscriberDto = subscriberConverter.convert(subscriberModel);
		return subscriberDto;
	}

}
