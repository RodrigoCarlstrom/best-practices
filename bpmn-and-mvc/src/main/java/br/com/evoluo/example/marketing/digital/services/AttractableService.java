package br.com.evoluo.example.marketing.digital.services;

import br.com.evoluo.example.marketing.digital.Attractable;
import br.com.evoluo.example.marketing.digital.Fillable;

public interface AttractableService {

	public Attractable send(Attractable attractable);

	public Fillable toInterested(Attractable token);

}
