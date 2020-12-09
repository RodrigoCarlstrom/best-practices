package br.com.evoluo.example.marketing.digital.services.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.commons.ValidateUtils;
import br.com.evoluo.example.commons.exception.ValidateException;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidOfferException;
import br.com.evoluo.example.marketing.digital.model.Offer;
import br.com.evoluo.example.marketing.digital.model.Prospect;
import br.com.evoluo.example.marketing.digital.services.AttractableService;

@Service
public class MailService implements AttractableService {

	private static final SimpleLogger log = SimpleLogger.getLogger(MailService.class.getName());
	
	@Autowired
	private ValidateUtils validator;

	public void send(String to, String subject, String text) {
		log.start("send", to, subject, text);
		// TODO: Implementar método de envio de e-mail
		log.end("send");
	}

	@Override
	public void send(@Valid Offer offer) {
		log.start("send", offer);
		this.send(offer.getRecipient(), offer.getCampaign().getName(), offer.getCampaign().getContent());
		log.end("send");
	}

	@Override
	public Prospect toInterested(Offer offer) {
		return new Prospect(offer);
	}

	@Override
	public void validate(Offer offer) throws InvalidOfferException {
		log.start("validate", offer);
		try {
			validator.validate(offer);
		} catch (ValidateException e) {
			throw new InvalidOfferException(e);
		}
		log.end("validate");
	}

}
