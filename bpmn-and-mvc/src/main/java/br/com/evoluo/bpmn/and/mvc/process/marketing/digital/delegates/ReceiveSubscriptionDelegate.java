package br.com.evoluo.bpmn.and.mvc.process.marketing.digital.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.evoluo.bpmn.and.mvc.commons.SimpleLogger;
import br.com.evoluo.bpmn.and.mvc.model.Contract;
import br.com.evoluo.bpmn.and.mvc.services.SignableService;

public class ReceiveSubscriptionDelegate implements JavaDelegate {
	
	SimpleLogger log = SimpleLogger.getLogger(ReceiveSubscriptionDelegate.class.getName());
	
	@Autowired
	private SignableService service;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.start("execute");
		Contract contract = (Contract) execution.getVariable("toke");
		service.validate(contract);
		execution.setVariable("token", service.receiveSubscription(contract));
		log.end("execution");
	}

}
