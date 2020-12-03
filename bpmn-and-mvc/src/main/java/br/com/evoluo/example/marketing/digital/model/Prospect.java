package br.com.evoluo.example.marketing.digital.model;

import java.io.Serializable;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.marketing.digital.model.offer.DigitalMarketingStatus;
import br.com.evoluo.example.marketing.digital.model.prospect.Contact;
import lombok.Data;

@Data
public class Prospect extends Offer implements Serializable {

	private static final SimpleLogger log = SimpleLogger.getLogger(Prospect.class.getName());

	private static final long serialVersionUID = 3202569613869170816L;

	private Contact contact;

	public Prospect() {
		this.setStatus(DigitalMarketingStatus.ATTRACTED);
	}

	public Prospect(Offer offert) {
		this();
		this.setCampaign(offert.getCampaign());
		this.setRecipient(offert.getRecipient());
	}

}
