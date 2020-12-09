package br.com.evoluo.example.marketing.digital.services;

import br.com.evoluo.example.marketing.digital.exceptions.InvalidOfferException;
import br.com.evoluo.example.marketing.digital.model.Offer;
import br.com.evoluo.example.marketing.digital.model.Prospect;

public interface AttractableService {

	public void send(Offer offer);

	public Prospect toInterested(Offer offer);

	public void validate(Offer offer) throws InvalidOfferException;

}
