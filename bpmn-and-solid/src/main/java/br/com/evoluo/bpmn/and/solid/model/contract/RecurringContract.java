package br.com.evoluo.bpmn.and.solid.model.contract;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import br.com.evoluo.bpmn.and.solid.commons.ValidateUtils;
import br.com.evoluo.bpmn.and.solid.model.Contract;
import br.com.evoluo.bpmn.and.solid.model.Sale;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.Signable;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.exceptions.InvalidContractException;

public class RecurringContract extends Contract implements Signable, Serializable {

	private static final long serialVersionUID = -3460396156303253602L;

	private Map<Date, Double> installments;

	public RecurringContract() {
		super();
	}

	public RecurringContract(Sale sale) {
		super(sale);
		Double installmentValue = sale.getValue() / sale.getNumberOfInstallments();
		this.installments = new LinkedHashMap<Date, Double>();
		for (int i = 0; i < sale.getNumberOfInstallments(); i++) {
			this.installments.put(
					Date.from(LocalDate.now().plusMonths(i).atStartOfDay(ZoneId.systemDefault()).toInstant()),
					installmentValue);
		}
	}

	@Override
	public void validadeContract() throws InvalidContractException {
		super.validadeContract();
		if (ValidateUtils.isNull(this.installments) || this.installments.size() < 2)
			throw new InvalidContractException("Recurring contract needs at least two installments!");
	}

}
