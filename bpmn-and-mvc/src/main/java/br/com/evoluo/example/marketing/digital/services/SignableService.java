package br.com.evoluo.example.marketing.digital.services;

import br.com.evoluo.example.marketing.digital.Provisionable;
import br.com.evoluo.example.marketing.digital.Signable;

public interface SignableService {

	public void submitContract(Signable token);

	public Provisionable receiveSubscription(Signable token);

}
