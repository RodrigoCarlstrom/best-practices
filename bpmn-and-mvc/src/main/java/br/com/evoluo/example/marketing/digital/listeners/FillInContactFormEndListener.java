package br.com.evoluo.example.marketing.digital.listeners;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.marketing.digital.Fillable;
import br.com.evoluo.example.marketing.digital.services.FillableService;

@Component
public class FillInContactFormEndListener implements ExecutionListener {
	
	private static final SimpleLogger log = SimpleLogger.getLogger(FillInContactFormEndListener.class.getName());
	
	@Autowired
	private FillableService service;

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		log.start("notify");
		Fillable token = (Fillable) execution.getVariable("token");
		execution.setVariable("token", service.fillForm(token));
		log.end("notify");
	}

}
