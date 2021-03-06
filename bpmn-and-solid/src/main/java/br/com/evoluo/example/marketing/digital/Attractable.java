package br.com.evoluo.example.marketing.digital;

import br.com.evoluo.example.marketing.digital.exceptions.InvalidOfferException;

public interface Attractable {
	
	public void validateOffer() throws InvalidOfferException;

	public Attractable sendOffer();

	public Fillable toInterested();
	

}
