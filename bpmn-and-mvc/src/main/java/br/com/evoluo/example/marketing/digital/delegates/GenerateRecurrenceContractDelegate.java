package br.com.evoluo.example.marketing.digital.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.marketing.digital.Contractable;

@Component
public class GenerateRecurrenceContractDelegate implements JavaDelegate {

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
