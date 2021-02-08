package br.com.evoluo.bpmn.and.mvc.services;

import br.com.evoluo.bpmn.and.mvc.exceptions.InvalidSaleException;
import br.com.evoluo.bpmn.and.mvc.model.Sale;
import br.com.evoluo.bpmn.and.mvc.model.contract.RecurringContract;
import br.com.evoluo.bpmn.and.mvc.model.contract.SingleContract;

public interface ContractableService {

	public SingleContract generateSingleContract(Sale sale);

	public RecurringContract generateRecurrenceContract(Sale sale);

	public void validate(Sale sale) throws InvalidSaleException;

}
