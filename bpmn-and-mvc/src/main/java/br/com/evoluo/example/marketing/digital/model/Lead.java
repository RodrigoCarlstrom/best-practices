package br.com.evoluo.example.marketing.digital.model;

import java.io.Serializable;

import br.com.evoluo.example.marketing.digital.model.offer.DigitalMarketingStatus;

public class Lead extends Prospect implements Serializable {

	private static final long serialVersionUID = -7132324941476667167L;

	public Lead() {
		this.setStatus(DigitalMarketingStatus.CONVERTED);
	}

	public Lead(Prospect prospect) {
		super(prospect);
		this.setStatus(DigitalMarketingStatus.CONVERTED);
		this.setContact(prospect.getContact());
	}

}
