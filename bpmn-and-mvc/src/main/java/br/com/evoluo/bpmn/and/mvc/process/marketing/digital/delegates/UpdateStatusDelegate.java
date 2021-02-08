package br.com.evoluo.bpmn.and.mvc.process.marketing.digital.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import br.com.evoluo.bpmn.and.mvc.commons.SimpleLogger;

@Component
public class UpdateStatusDelegate implements JavaDelegate {

	private static final SimpleLogger log = SimpleLogger.getLogger(UpdateSalesFunnelDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.start("execute");
		execution.getProcessEngineServices().getRuntimeService().correlateMessage("statusChanged",
				execution.getBusinessKey());
		log.end("execute");
	}

}
