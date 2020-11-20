package br.com.evoluo.example.marketing.digital.model.contract;

import java.io.Serializable;

import br.com.evoluo.example.commons.ValidateUtils;
import br.com.evoluo.example.marketing.digital.Signable;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidContractException;
import br.com.evoluo.example.marketing.digital.model.Contract;
import lombok.Data;

@Data
public class SingleContract extends Contract implements Signable, Serializable {

	private static final long serialVersionUID = -3460396156303253602L;

	private Double value;

	@Override
	public void validadeContract() throws InvalidContractException {
		super.validadeContract();
		if (ValidateUtils.isNull(this.value))
			throw new InvalidContractException("Contract valie is null!");
	}

}
