package br.com.evoluo.example.marketing.digital.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.commons.services.SalesService;
import br.com.evoluo.example.marketing.digital.Situable;

@Component
public class UpdateSalesFunnelDelegate implements JavaDelegate {

	private SalesService service = new SalesService();
	private static final SimpleLogger log = SimpleLogger.getLogger(UpdateSalesFunnelDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.start("execute");
		service.updateFunnel((Situable) execution.getVariable("token"));
		execution.getProcessEngineServices().getRuntimeService().createMessageCorrelation("statusChanged").processInstanceBusinessKey(execution.getBusinessKey()).correlate();
		log.end("execute");
	}

}
