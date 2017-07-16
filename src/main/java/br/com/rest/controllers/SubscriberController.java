package br.com.rest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rest.dtos.SubscriberDTO;
import br.com.rest.facades.SubscriberFacade;
import br.com.rest.requests.SubscriberRequestBody;

@RestController
public class SubscriberController {
	
	@Autowired
	SubscriberFacade subscriberFacade;
	
	@RequestMapping(path="/subscribers", method=RequestMethod.POST)
	public SubscriberDTO createSubscriber(@Valid @RequestBody SubscriberRequestBody request){
		return subscriberFacade.createSubscriber(request.getEmail(), request.getCategoryCodes());
	}
	
}
