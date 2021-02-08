package br.com.evoluo.bpmn.and.solid.process.marketing.digital.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import br.com.evoluo.bpmn.and.solid.commons.SimpleLogger;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.Attractable;

@Component
public class SendOfferDelegate implements JavaDelegate {
	
	private static final SimpleLogger log = SimpleLogger.getLogger(SendOfferDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.start("execute");
		Attractable token = (Attractable) execution.getVariable("token");
		token.validateOffer();
		execution.setVariable("token", token.sendOffer());
		log.end("execute");
	}
	

}
