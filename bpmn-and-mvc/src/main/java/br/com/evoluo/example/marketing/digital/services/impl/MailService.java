package br.com.evoluo.example.marketing.digital.services.impl;

import org.springframework.stereotype.Service;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.marketing.digital.Attractable;
import br.com.evoluo.example.marketing.digital.Fillable;
import br.com.evoluo.example.marketing.digital.services.AttractableService;

@Service
public class MailService implements AttractableService {

	private static final SimpleLogger log = SimpleLogger.getLogger(MailService.class.getName());

	public void send(String to, String subject, String text) {
		log.start("send", to, subject, text);
		//TODO: Implementar método de envio de e-mail
		log.end("send");
	}

	@Override
	public Attractable send(Attractable attractable) {
		log.start("send", attractable);
		this.send(attractable.getRecipient(), attractable.getCampaign().getName(), attractable.getCampaign().getContent());
		log.ret("send" , attractable);
		return attractable;
	}

	@Override
	public Fillable toInterested(Attractable token) {
		// TODO Auto-generated method stub
		return null;
	}

}
