package br.com.evoluo.bpmn.and.mvc.process.marketing.digital.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.evoluo.bpmn.and.mvc.commons.SimpleLogger;
import br.com.evoluo.bpmn.and.mvc.model.Offer;
import br.com.evoluo.bpmn.and.mvc.services.SituableService;

@Component
public class UpdateSalesFunnelDelegate implements JavaDelegate {

	private static final SimpleLogger log = SimpleLogger.getLogger(UpdateSalesFunnelDelegate.class.getName());
	
	@Autowired
	private SituableService service;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.start("execute");
		Offer offer = (Offer) execution.getVariable("token");
		service.updateFunnel(offer);
		log.end("execute");
	}

}
