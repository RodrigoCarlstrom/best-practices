package br.com.evoluo.example.marketing.digital.model.contract;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import br.com.evoluo.example.commons.ValidateUtils;
import br.com.evoluo.example.marketing.digital.Signable;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidContractException;
import br.com.evoluo.example.marketing.digital.model.Contract;

public class RecurringContract extends Contract implements Signable, Serializable {

	private static final long serialVersionUID = -3460396156303253602L;

	private Map<Date, Double> installments;

	@Override
	public void validadeContract() throws InvalidContractException {
		super.validadeContract();
		if (ValidateUtils.isNull(this.installments) || this.installments.size() < 2)
			throw new InvalidContractException("Recurring contract needs at least two installments!");
	}

}
