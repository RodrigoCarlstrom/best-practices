package br.com.evoluo.bpmn.and.solid.model;

import java.io.Serializable;

import br.com.evoluo.bpmn.and.solid.commons.SimpleLogger;
import br.com.evoluo.bpmn.and.solid.commons.ValidateUtils;
import br.com.evoluo.bpmn.and.solid.model.offer.DigitalMarketingStatus;
import br.com.evoluo.bpmn.and.solid.model.prospect.Contact;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.Fillable;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.Negotiable;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.exceptions.InvalidProspectException;
import lombok.Data;

@Data
public class Prospect extends Offer implements Fillable, Serializable {

	private static final SimpleLogger log = SimpleLogger.getLogger(Prospect.class.getName());

	private static final long serialVersionUID = 3202569613869170816L;

	private Contact contact;

	public Prospect() {
		this.setStatus(DigitalMarketingStatus.ATTRACTED);
	}

	public Prospect(Offer offer) {
		this();
		this.setCampaign(offer.getCampaign());
		this.setRecipient(offer.getRecipient());
	}

	@Override
	public void validadeProspect() throws InvalidProspectException {
		log.start("validadeProspect");
		if (ValidateUtils.isNull(this.contact))
			throw new InvalidProspectException("Prospect contact is null!");
		contact.validate();
		log.end("validadeProspect");
	}

	@Override
	public Negotiable fillForm() {
		log.start("fillForm");
		Lead lead = new Lead(this);
		log.ret("fillForm", lead);
		return lead;
	}

}
