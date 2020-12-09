package br.com.evoluo.example.marketing.digital.listeners;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.marketing.digital.model.Prospect;
import br.com.evoluo.example.marketing.digital.services.FillableService;

@Component
public class FillInContactFormEndListener implements ExecutionListener {
	
	private static final SimpleLogger log = SimpleLogger.getLogger(FillInContactFormEndListener.class.getName());
	
	@Autowired
	private FillableService service;

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		log.start("notify");
		Prospect prospect = (Prospect) execution.getVariable("token");
		service.validate(prospect);
		execution.setVariable("token", service.fillForm(prospect));
		log.end("notify");
	}

}
