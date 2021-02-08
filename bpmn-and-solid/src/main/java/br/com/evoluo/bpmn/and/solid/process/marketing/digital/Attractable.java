package br.com.evoluo.bpmn.and.solid.process.marketing.digital;

import br.com.evoluo.bpmn.and.solid.process.marketing.digital.exceptions.InvalidOfferException;

public interface Attractable {
	
	public void validateOffer() throws InvalidOfferException;

	public Attractable sendOffer();

	public Fillable toInterested();
	

}
