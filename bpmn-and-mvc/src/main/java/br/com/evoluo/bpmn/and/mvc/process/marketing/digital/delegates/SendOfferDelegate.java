package br.com.evoluo.bpmn.and.mvc.process.marketing.digital.delegates;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.evoluo.bpmn.and.mvc.commons.SimpleLogger;
import br.com.evoluo.bpmn.and.mvc.exceptions.InvalidOfferException;
import br.com.evoluo.bpmn.and.mvc.model.Offer;
import br.com.evoluo.bpmn.and.mvc.services.AttractableService;

@Component
public class SendOfferDelegate implements JavaDelegate {

	private static final SimpleLogger log = SimpleLogger.getLogger(SendOfferDelegate.class.getName());

	@Autowired
	private AttractableService service;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.start("execute");
		Offer offer = (Offer) execution.getVariable("token");
		try {
			service.validate(offer);
		} catch (InvalidOfferException e) {
			throw new BpmnError("InvalidOffer", e.getMessage(), e);
		}
		service.send(offer);
		log.end("execute");
	}

}