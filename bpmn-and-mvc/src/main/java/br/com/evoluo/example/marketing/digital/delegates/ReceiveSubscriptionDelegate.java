package br.com.evoluo.example.marketing.digital.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.marketing.digital.model.Contract;
import br.com.evoluo.example.marketing.digital.services.SignableService;

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
