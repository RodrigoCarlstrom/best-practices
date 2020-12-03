package br.com.evoluo.example.marketing.digital.services;

import br.com.evoluo.example.marketing.digital.model.Contract;

public interface SignableService {

	public void submitContract(Contract contract);

	public Contract receiveSubscription(Contract contract);

}
