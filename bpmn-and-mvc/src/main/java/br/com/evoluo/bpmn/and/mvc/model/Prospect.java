package br.com.evoluo.bpmn.and.mvc.model;

import java.io.Serializable;

import br.com.evoluo.bpmn.and.mvc.commons.SimpleLogger;
import br.com.evoluo.bpmn.and.mvc.model.offer.DigitalMarketingStatus;
import br.com.evoluo.bpmn.and.mvc.model.prospect.Contact;
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
