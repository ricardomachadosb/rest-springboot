package br.com.rest.converters;

import br.com.rest.dtos.SubscriberDTO;
import br.com.rest.models.SubscriberModel;

public interface SubscriberConverter {
	public SubscriberDTO convert(SubscriberModel subscriberModel);
}
