package br.com.evoluo.bpmn.and.mvc.model;

import java.io.Serializable;
import java.util.Date;

import br.com.evoluo.bpmn.and.mvc.model.contract.Signature;
import br.com.evoluo.bpmn.and.mvc.model.offer.DigitalMarketingStatus;
import lombok.Data;

@Data
public class Contract extends Sale implements Serializable {

	private static final long serialVersionUID = -815339126067796156L;

	private Date contractDate;
	private Signature signature;

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

}
