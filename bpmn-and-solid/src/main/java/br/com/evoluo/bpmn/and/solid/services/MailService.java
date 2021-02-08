package br.com.evoluo.bpmn.and.solid.services;

import org.springframework.stereotype.Service;

import br.com.evoluo.bpmn.and.solid.commons.SimpleLogger;
import br.com.evoluo.bpmn.and.solid.model.offer.MailOffer;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.Attractable;

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
