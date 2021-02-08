package br.com.evoluo.bpmn.and.solid.process.marketing.digital;

import br.com.evoluo.bpmn.and.solid.process.marketing.digital.exceptions.InvalidContractException;

public interface Signable {
	
	public void validadeContract() throws InvalidContractException;

	public Signable submitContract();

	public Provisionable receiveSubscription();

}
