package br.com.evoluo.example.marketing.digital.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.commons.services.SalesService;
import br.com.evoluo.example.marketing.digital.Signable;

@Component
public class SubmitContractDelegate implements JavaDelegate {

	private static final SimpleLogger log = SimpleLogger.getLogger(SubmitContractDelegate.class.getName());
	private SalesService service = new SalesService();

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.start("execute");
		service.submitContract((Signable) execution.getVariable("token"));
		log.end("execute");
	}

}
