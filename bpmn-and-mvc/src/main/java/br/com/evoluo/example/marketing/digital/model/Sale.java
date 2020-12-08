package br.com.evoluo.example.marketing.digital.model;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.commons.ValidateUtils;
import br.com.evoluo.example.marketing.digital.exceptions.DigitalMarketingException;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidLeadException;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidSaleException;
import br.com.evoluo.example.marketing.digital.model.offer.DigitalMarketingStatus;
import br.com.evoluo.example.marketing.digital.model.sale.ContractType;
import br.com.evoluo.example.marketing.digital.model.sale.SaleResult;
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
