package br.com.evoluo.bpmn.and.solid.process.marketing.digital.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import br.com.evoluo.bpmn.and.solid.commons.SimpleLogger;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.Signable;
import br.com.evoluo.bpmn.and.solid.services.SalesService;

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
