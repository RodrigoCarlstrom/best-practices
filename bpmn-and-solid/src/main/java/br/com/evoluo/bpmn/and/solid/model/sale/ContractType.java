package br.com.evoluo.bpmn.and.solid.model.sale;

import br.com.evoluo.bpmn.and.solid.model.contract.RecurringContract;
import br.com.evoluo.bpmn.and.solid.model.contract.SingleContract;

public enum ContractType {
	SINGLE(SingleContract.class.getName()), RECURRENT(RecurringContract.class.getName());

	private String contractClass;

	private ContractType(String contractClass) {
		this.contractClass = contractClass;
	}

	public String getContractClass() {
		return this.contractClass;
	}
}
