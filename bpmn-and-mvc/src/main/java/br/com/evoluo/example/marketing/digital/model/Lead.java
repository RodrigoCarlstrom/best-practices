package br.com.evoluo.example.marketing.digital.model;

import java.io.Serializable;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.marketing.digital.Contractable;
import br.com.evoluo.example.marketing.digital.Negotiable;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidLeadException;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidProspectException;
import br.com.evoluo.example.marketing.digital.model.offer.DigitalMarketingStatus;

public class Lead extends Prospect implements Negotiable, Serializable {

	private static final long serialVersionUID = -7132324941476667167L;

	private static final SimpleLogger log = SimpleLogger.getLogger(Lead.class.getName());

	public Lead() {
		this.setStatus(DigitalMarketingStatus.CONVERTED);
	}

	public Lead(Prospect prospect) {
		super(prospect);
		this.setStatus(DigitalMarketingStatus.CONVERTED);
		this.setContact(prospect.getContact());
	}

	@Override
	public void validateLead() throws InvalidLeadException {
		log.start("validateLead");
		try {
			this.validadeProspect();
		} catch (InvalidProspectException e) {
			e.printStackTrace();
			throw new InvalidLeadException("Propect invalid");
		}
		log.end("validateLead");
	}

	@Override
	public Contractable negotiate() {
		// TODO Auto-generated method stub
		return null;
	}

}
