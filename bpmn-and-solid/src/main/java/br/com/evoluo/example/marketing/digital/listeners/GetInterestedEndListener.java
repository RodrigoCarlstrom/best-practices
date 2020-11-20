package br.com.evoluo.example.marketing.digital.listeners;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.marketing.digital.Attractable;

@Component
public class GetInterestedEndListener implements ExecutionListener {
	
	SimpleLogger log = SimpleLogger.getLogger(GetInterestedEndListener.class.getName());

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		log.start("notify");
		Attractable token = (Attractable) execution.getVariable("token");
		execution.setVariable("token", token.toInterested());
		log.end("notify");
	}

}
