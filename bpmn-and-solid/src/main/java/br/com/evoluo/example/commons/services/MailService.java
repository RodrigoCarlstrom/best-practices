package br.com.evoluo.example.commons.services;

import org.springframework.stereotype.Service;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.marketing.digital.Attractable;
import br.com.evoluo.example.marketing.digital.model.offer.MailOffer;

@Service
public class MailService {

	private static final SimpleLogger log = SimpleLogger.getLogger(MailService.class.getName());

	public Attractable send(MailOffer offer) {
		log.start("send", offer);
		this.send(offer.getRecipient(), offer.getCampaign().getName(), offer.getCampaign().getContent());
		log.ret("send" , offer);
		return offer;
	}

	public void send(String to, String subject, String text) {
		log.start("send", to, subject, text);
		//TODO: Implementar método de envio de e-mail
		log.end("send");
	}

}
