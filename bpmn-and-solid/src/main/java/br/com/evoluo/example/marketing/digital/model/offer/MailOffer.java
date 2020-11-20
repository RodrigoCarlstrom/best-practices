package br.com.evoluo.example.marketing.digital.model.offer;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Configurable;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.commons.services.MailService;
import br.com.evoluo.example.marketing.digital.Attractable;
import br.com.evoluo.example.marketing.digital.Fillable;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidOfferException;
import br.com.evoluo.example.marketing.digital.model.Offer;
import br.com.evoluo.example.marketing.digital.model.Prospect;

@Configurable
public class MailOffer extends Offer implements Attractable, Serializable {

	private static final SimpleLogger log = SimpleLogger.getLogger(MailOffer.class.getName());

	private static final long serialVersionUID = 6066288072156920369L;

	// FIXME: Configurar o spring com AspectJ para poder injetar esta instância via
	// @Autowired. Isto será necessário pos que inicia a classe MailOffer é o
	// Camunda, através do comando execution.getVariable("token").
	private MailService service = new MailService();

	@Override
	public void validateOffer() throws InvalidOfferException {
		log.start("validateOffer");
		super.validate();
		log.end("validateOffer");
	}

	@Override
	public Attractable sendOffer() {
		log.start("sendOffer");
		Attractable ret = this.service.send(this);
		log.ret("sendOffer", ret);
		return ret;
	}

	@Override
	public Fillable toInterested() {
		log.start("toInterested");
		Prospect prospect = new Prospect(this);
		log.ret("toInterested", prospect);
		return prospect;
	}

}
