package br.com.evoluo.bpmn.and.mvc.model;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import br.com.evoluo.bpmn.and.mvc.commons.SimpleLogger;
import br.com.evoluo.bpmn.and.mvc.commons.ValidateUtils;
import br.com.evoluo.bpmn.and.mvc.exceptions.DigitalMarketingException;
import br.com.evoluo.bpmn.and.mvc.exceptions.InvalidLeadException;
import br.com.evoluo.bpmn.and.mvc.exceptions.InvalidSaleException;
import br.com.evoluo.bpmn.and.mvc.model.offer.DigitalMarketingStatus;
import br.com.evoluo.bpmn.and.mvc.model.sale.ContractType;
import br.com.evoluo.bpmn.and.mvc.model.sale.SaleResult;
import lombok.Data;

@Data
public class Sale extends Lead implements Serializable {

	private static final long serialVersionUID = -6965376199622817088L;

	private SaleResult result;
	private Double value;
	private ContractType contractType;
	private Integer numberOfInstallments;
	private String comments;

	public Sale() {
		super();
		this.setStatus(DigitalMarketingStatus.CONQUERED);
	}

	public Sale(Lead lead) {
		super(lead);
		this.setStatus(DigitalMarketingStatus.CONQUERED);
	}

}
