package br.com.evoluo.example.marketing.digital.listeners;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.marketing.digital.model.Offer;
import br.com.evoluo.example.marketing.digital.services.AttractableService;

@Component
public class GetInterestedEndListener implements ExecutionListener {
	
	SimpleLogger log = SimpleLogger.getLogger(GetInterestedEndListener.class.getName());
	
	@Autowired
	private AttractableService service;

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		log.start("notify");
		Offer offer = (Offer) execution.getVariable("token");
		execution.setVariable("token", service.toInterested(offer));
		log.end("notify");
	}

}
