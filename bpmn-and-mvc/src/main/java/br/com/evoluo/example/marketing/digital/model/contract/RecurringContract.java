package br.com.evoluo.example.marketing.digital.model.contract;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import br.com.evoluo.example.commons.ValidateUtils;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidContractException;
import br.com.evoluo.example.marketing.digital.model.Contract;
import br.com.evoluo.example.marketing.digital.model.Sale;

public class RecurringContract extends Contract implements Serializable {

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

}
