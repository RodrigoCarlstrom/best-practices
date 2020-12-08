package br.com.evoluo.example.marketing.digital.services;

import br.com.evoluo.example.marketing.digital.model.Sale;
import br.com.evoluo.example.marketing.digital.model.contract.RecurringContract;
import br.com.evoluo.example.marketing.digital.model.contract.SingleContract;

public interface ContractableService {

	public SingleContract generateSingleContract(Sale sale);

	public RecurringContract generateRecurrenceContract(Sale sale);

}
