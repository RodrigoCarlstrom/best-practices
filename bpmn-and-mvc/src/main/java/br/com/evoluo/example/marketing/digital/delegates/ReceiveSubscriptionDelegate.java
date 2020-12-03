package br.com.evoluo.example.marketing.digital.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.marketing.digital.Signable;
import br.com.evoluo.example.marketing.digital.services.SignableService;

public class ReceiveSubscriptionDelegate implements JavaDelegate {
	
	SimpleLogger log = SimpleLogger.getLogger(ReceiveSubscriptionDelegate.class.getName());
	
	@Autowired
	private SignableService service;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.start("execute");
		Signable token = (Signable) execution.getVariable("toke");
		execution.setVariable("token", service.receiveSubscription(token));
		log.end("execution");
	}

}
