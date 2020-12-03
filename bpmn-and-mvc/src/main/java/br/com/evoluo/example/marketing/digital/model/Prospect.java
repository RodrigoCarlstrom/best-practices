package br.com.evoluo.example.marketing.digital.model;

import java.io.Serializable;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.commons.ValidateUtils;
import br.com.evoluo.example.marketing.digital.Fillable;
import br.com.evoluo.example.marketing.digital.Negotiable;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidProspectException;
import br.com.evoluo.example.marketing.digital.model.offer.DigitalMarketingStatus;
import br.com.evoluo.example.marketing.digital.model.prospect.Contact;
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
