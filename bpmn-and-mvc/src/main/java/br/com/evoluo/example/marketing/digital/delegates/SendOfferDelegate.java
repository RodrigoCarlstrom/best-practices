package br.com.evoluo.example.marketing.digital.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.marketing.digital.model.Offer;
import br.com.evoluo.example.marketing.digital.services.AttractableService;

@Component
public class SendOfferDelegate implements JavaDelegate {
	
	private static final SimpleLogger log = SimpleLogger.getLogger(SendOfferDelegate.class.getName());
	
	@Autowired
	private AttractableService service;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.start("execute");
		Offer offer = (Offer) execution.getVariable("token");
		service.send(offer);
		log.end("execute");
	}
	

}