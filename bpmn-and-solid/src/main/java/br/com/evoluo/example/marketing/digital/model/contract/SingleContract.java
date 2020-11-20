package br.com.evoluo.example.marketing.digital.model.contract;

import java.io.Serializable;

import br.com.evoluo.example.commons.ValidateUtils;
import br.com.evoluo.example.marketing.digital.Signable;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidContractException;
import br.com.evoluo.example.marketing.digital.model.Contract;
import br.com.evoluo.example.marketing.digital.model.Sale;
import lombok.Data;

@Data
public class SingleContract extends Contract implements Signable, Serializable {

	private static final long serialVersionUID = -3460396156303253602L;

	private Double contractValue;
	
	public SingleContract() {
		super();
	}
	
	public SingleContract(Sale sale) {
		super(sale);
		this.contractValue = sale.getValue();
	}

	@Override
	public void validadeContract() throws InvalidContractException {
		super.validadeContract();
		if (ValidateUtils.isNull(this.contractValue))
			throw new InvalidContractException("Contract valie is null!");
	}

}
