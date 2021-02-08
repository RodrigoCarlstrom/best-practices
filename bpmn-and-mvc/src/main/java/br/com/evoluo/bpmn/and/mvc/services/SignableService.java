package br.com.evoluo.bpmn.and.mvc.services;

import br.com.evoluo.bpmn.and.mvc.exceptions.InvalidContractException;
import br.com.evoluo.bpmn.and.mvc.model.Contract;

public interface SignableService {

	public void submitContract(Contract contract);

	public Contract receiveSubscription(Contract contract);

	public void validate(Contract contract) throws InvalidContractException;

}
