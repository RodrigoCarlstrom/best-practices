package br.com.evoluo.example.marketing.digital.services.impl;

import org.springframework.stereotype.Service;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.marketing.digital.model.Offer;
import br.com.evoluo.example.marketing.digital.model.Prospect;
import br.com.evoluo.example.marketing.digital.services.AttractableService;

@Service
public class MailService implements AttractableService {

	private static final SimpleLogger log = SimpleLogger.getLogger(MailService.class.getName());

	public void send(String to, String subject, String text) {
		log.start("send", to, subject, text);
		// TODO: Implementar método de envio de e-mail
		log.end("send");
	}

	@Override
	public void send(Offer offer) {
		log.start("send", offer);
		this.send(offer.getRecipient(), offer.getCampaign().getName(), offer.getCampaign().getContent());
		log.end("send");
	}

	@Override
	public Prospect toInterested(Offer offer) {
		return new Prospect(offer);
	}

}
