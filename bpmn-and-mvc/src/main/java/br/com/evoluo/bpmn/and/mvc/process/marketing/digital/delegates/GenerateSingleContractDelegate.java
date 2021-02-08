package br.com.evoluo.bpmn.and.mvc.process.marketing.digital.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.evoluo.bpmn.and.mvc.commons.SimpleLogger;
import br.com.evoluo.bpmn.and.mvc.model.Sale;
import br.com.evoluo.bpmn.and.mvc.services.ContractableService;

@Component
public class GenerateSingleContractDelegate implements JavaDelegate {

	private static final SimpleLogger log = SimpleLogger.getLogger(GenerateSingleContractDelegate.class.getName());
	
	@Autowired
	private ContractableService service;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.start("execute");
		Sale sale = (Sale) execution.getVariable("token");
		service.validate(sale);
		execution.setVariable("token", service.generateSingleContract(sale));
		log.end("execute");
	}

}
