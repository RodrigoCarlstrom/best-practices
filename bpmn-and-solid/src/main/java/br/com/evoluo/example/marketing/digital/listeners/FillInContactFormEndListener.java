package br.com.evoluo.example.marketing.digital.listeners;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.marketing.digital.Fillable;

@Component
public class FillInContactFormEndListener implements ExecutionListener {
	
	private static final SimpleLogger log = SimpleLogger.getLogger(FillInContactFormEndListener.class.getName());

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		log.start("notify");
		Fillable prospect = (Fillable) execution.getVariable("token");
		prospect.validadeProspect();
		execution.setVariable("token", prospect.fillForm());
		log.end("notify");
	}

}
