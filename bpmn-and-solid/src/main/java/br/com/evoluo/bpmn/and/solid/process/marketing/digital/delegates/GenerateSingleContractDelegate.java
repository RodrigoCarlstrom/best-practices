package br.com.evoluo.bpmn.and.solid.process.marketing.digital.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import br.com.evoluo.bpmn.and.solid.commons.SimpleLogger;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.Contractable;

@Component
public class GenerateSingleContractDelegate implements JavaDelegate {

	private static final SimpleLogger log = SimpleLogger.getLogger(GenerateSingleContractDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.start("execute");
		Contractable sale = (Contractable) execution.getVariable("token");
		sale.validateSale();
		execution.setVariable("token", sale.generateContract());
		log.end("execute");
	}

}
