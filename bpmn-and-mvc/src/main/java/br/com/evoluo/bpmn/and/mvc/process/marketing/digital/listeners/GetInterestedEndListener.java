package br.com.evoluo.bpmn.and.mvc.process.marketing.digital.listeners;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.evoluo.bpmn.and.mvc.commons.SimpleLogger;
import br.com.evoluo.bpmn.and.mvc.model.Offer;
import br.com.evoluo.bpmn.and.mvc.services.AttractableService;

@Component
public class GetInterestedEndListener implements ExecutionListener {
	
	SimpleLogger log = SimpleLogger.getLogger(GetInterestedEndListener.class.getName());
	
	@Autowired
	private AttractableService service;

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		log.start("notify");
		Offer offer = (Offer) execution.getVariable("token");
		service.validate(offer);
		execution.setVariable("token", service.toInterested(offer));
		log.end("notify");
	}

}
