package br.com.evoluo.example.marketing.digital.model;

import java.io.Serializable;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.commons.ValidateUtils;
import br.com.evoluo.example.commons.services.SalesService;
import br.com.evoluo.example.marketing.digital.Situable;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidOfferException;
import br.com.evoluo.example.marketing.digital.model.offer.Campaign;
import br.com.evoluo.example.marketing.digital.model.offer.DigitalMarketingStatus;
import lombok.Data;

@Data
public abstract class Offer implements Situable, Serializable {

	private static final SimpleLogger log = SimpleLogger.getLogger(Offer.class.getName());

	private static final long serialVersionUID = -6037614396403161428L;

	private SalesService salesService = new SalesService();

	private String recipient;
	private DigitalMarketingStatus status = DigitalMarketingStatus.UNKNOWED;
	private Campaign campaign;

	public void validate() throws InvalidOfferException {
		log.start("validate");
		if (ValidateUtils.isEmpty(this.recipient))
			throw new InvalidOfferException("Offer recipient is empty!");
		if (ValidateUtils.isNull(this.status))
			throw new InvalidOfferException("Offer status is empty!");
		if (ValidateUtils.isNull(this.campaign))
			throw new InvalidOfferException("Offer campaign is null!");
		this.campaign.validate();
		log.end("validate");
	}

	@Override
	public void updateFunnel() {
		log.start("updateFunnel");
		salesService.updateFunnel(this);
		log.end("updateFunnel");
	}

}
