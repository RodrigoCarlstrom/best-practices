package br.com.evoluo.example.marketing.digital.model.sale;

import br.com.evoluo.example.marketing.digital.model.contract.RecurringContract;
import br.com.evoluo.example.marketing.digital.model.contract.SingleContract;

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
