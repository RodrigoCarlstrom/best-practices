package br.com.evoluo.bpmn.and.mvc.process.marketing.digital.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.evoluo.bpmn.and.mvc.commons.SimpleLogger;
import br.com.evoluo.bpmn.and.mvc.model.Contract;
import br.com.evoluo.bpmn.and.mvc.services.SignableService;

@Component
public class SubmitContractDelegate implements JavaDelegate {

	private static final SimpleLogger log = SimpleLogger.getLogger(SubmitContractDelegate.class.getName());

	@Autowired
	private SignableService service;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.start("execute");
		Contract contract = (Contract) execution.getVariable("token");
		service.validate(contract);
		service.submitContract(contract);
		log.end("execute");
	}

}
