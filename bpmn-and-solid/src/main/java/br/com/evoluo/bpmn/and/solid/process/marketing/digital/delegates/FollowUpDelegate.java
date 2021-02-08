package br.com.evoluo.bpmn.and.solid.process.marketing.digital.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import br.com.evoluo.bpmn.and.solid.commons.SimpleLogger;

@Component
public class FollowUpDelegate implements JavaDelegate {

	private static final SimpleLogger log = SimpleLogger.getLogger(FollowUpDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.start("execute");
		// TODO Auto-generated method stub
		log.end("execute");
	}

}
