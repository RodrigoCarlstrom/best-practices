package br.com.evoluo.bpmn.and.mvc.services;

import br.com.evoluo.bpmn.and.mvc.exceptions.InvalidOfferException;
import br.com.evoluo.bpmn.and.mvc.model.Offer;
import br.com.evoluo.bpmn.and.mvc.model.Prospect;

public interface AttractableService {

	public void send(Offer offer);

	public Prospect toInterested(Offer offer);

	public void validate(Offer offer) throws InvalidOfferException;

}
