package br.com.evoluo.example.marketing.digital.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.marketing.digital.Signable;
import br.com.evoluo.example.marketing.digital.services.SignableService;

@Component
public class SubmitContractDelegate implements JavaDelegate {

	private static final SimpleLogger log = SimpleLogger.getLogger(SubmitContractDelegate.class.getName());

	@Autowired
	private SignableService service;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.start("execute");
		Signable token = (Signable) execution.getVariable("token");
		service.submitContract(token);
		log.end("execute");
	}

}
