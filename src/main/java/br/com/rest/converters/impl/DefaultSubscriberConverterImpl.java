package br.com.rest.converters.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rest.converters.CategoryConverter;
import br.com.rest.converters.SubscriberConverter;
import br.com.rest.dtos.SubscriberDTO;
import br.com.rest.models.SubscriberModel;

@Component
public class DefaultSubscriberConverterImpl implements SubscriberConverter{

	@Autowired
	private CategoryConverter categoryConverter;
	
	@Override
	public SubscriberDTO convert(SubscriberModel subscriberModel) {
		SubscriberDTO subscriberDto = new SubscriberDTO(subscriberModel.getEmail(), null);
		subscriberDto.setCategories(categoryConverter.convertAll(subscriberModel.getCategories()));
		
		return subscriberDto;
	}

}
