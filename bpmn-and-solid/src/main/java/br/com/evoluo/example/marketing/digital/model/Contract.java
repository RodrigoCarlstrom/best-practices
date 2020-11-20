package br.com.evoluo.example.marketing.digital.model;

import java.io.Serializable;
import java.util.Date;

import br.com.evoluo.example.commons.ValidateUtils;
import br.com.evoluo.example.marketing.digital.Provisionable;
import br.com.evoluo.example.marketing.digital.Signable;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidContractException;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidSaleException;
import br.com.evoluo.example.marketing.digital.model.offer.DigitalMarketingStatus;
import lombok.Data;

@Data
public class Contract extends Sale implements Serializable {

	private static final long serialVersionUID = -815339126067796156L;

	private Date contractDate;

	public Contract() {
		super();
		this.setStatus(DigitalMarketingStatus.CONQUERED);
	}

	public Contract(Sale sale) {
		super(sale);
		this.setResult(sale.getResult());
		this.setContractType(sale.getContractType());
		this.setComments(sale.getComments());
		this.setStatus(DigitalMarketingStatus.CONQUERED);
	}

	public void validadeContract() throws InvalidContractException {
		if (ValidateUtils.isNull(this.contractDate))
			throw new InvalidContractException("Contract date is null!");
		try {
			super.validateSale();
		} catch (InvalidSaleException e) {
			e.printStackTrace();
			throw new InvalidContractException("Invalide sale!", e);
		}
	}

	public Signable submitContract() {
		// TODO Auto-generated method stub
		return null;
	}

	public Provisionable receiveSubscription() {
		// TODO Auto-generated method stub
		return null;
	}

}
