package br.com.evoluo.bpmn.and.solid.model;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import br.com.evoluo.bpmn.and.solid.commons.SimpleLogger;
import br.com.evoluo.bpmn.and.solid.commons.ValidateUtils;
import br.com.evoluo.bpmn.and.solid.model.offer.DigitalMarketingStatus;
import br.com.evoluo.bpmn.and.solid.model.sale.ContractType;
import br.com.evoluo.bpmn.and.solid.model.sale.SaleResult;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.Contractable;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.Signable;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.exceptions.DigitalMarketingException;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.exceptions.InvalidLeadException;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.exceptions.InvalidSaleException;
import lombok.Data;

@Data
public class Sale extends Lead implements Contractable, Serializable {

	private static final long serialVersionUID = -6965376199622817088L;

	private static final SimpleLogger log = SimpleLogger.getLogger(Sale.class.getName());

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

	@Override
	public void validateSale() throws InvalidSaleException {
		log.start("validateSale");
		try {
			super.validateLead();
		} catch (InvalidLeadException e) {
			e.printStackTrace();
			throw new InvalidSaleException(e.getMessage());
		}
		if (ValidateUtils.isNull(this.getResult()))
			throw new InvalidSaleException("Sales result is null!");
		if (this.result.equals(SaleResult.CLOSED)) {
			if (ValidateUtils.isNull(this.contractType))
				throw new InvalidSaleException("Sales contractType ins null!");
		}
		if (ValidateUtils.isEmpty(this.comments))
			throw new InvalidSaleException("Sales comments is empty!");
		log.end("validateSale");
	}

	@Override
	public Signable generateContract() throws DigitalMarketingException {
		log.start("generateContract");
		try {
			Signable contract = (Signable) Class.forName(this.contractType.getContractClass())
					.getConstructor(Sale.class).newInstance(this);
			log.ret("generateContract", contract);
			return contract;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new DigitalMarketingException("Could not instantiate type " + this.contractType + " contract!", e);
		}
	}

	@Override
	public Boolean giveUp() {
		log.start("giveUp");
		Boolean ret = this.result.equals(SaleResult.LOSTED);
		log.ret("giveUp", ret);
		return ret;
	}

	@Override
	public Boolean recurrent() {
		log.start("recurrent");
		Boolean ret = !ValidateUtils.isNull(this.contractType) && this.contractType.equals(ContractType.RECURRENT);
		log.ret("recurrent", ret);
		return ret;
	}

}
