package br.com.evoluo.bpmn.and.solid.process.marketing.digital.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import br.com.evoluo.bpmn.and.solid.commons.SimpleLogger;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.Situable;

@Component
public class UpdateSalesFunnelDelegate implements JavaDelegate {

	private static final SimpleLogger log = SimpleLogger.getLogger(UpdateSalesFunnelDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.start("execute");
		Situable funnel = (Situable) execution.getVariable("token");
		funnel.updateFunnel();
		log.end("execute");
	}

}
