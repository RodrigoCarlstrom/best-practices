package br.com.evoluo.example.marketing.digital;

import br.com.evoluo.example.marketing.digital.exceptions.InvalidContractException;

public interface Signable {
	
	public void validadeContract() throws InvalidContractException;

	public Signable submitContract();

	public Provisionable receiveSubscription();

}
