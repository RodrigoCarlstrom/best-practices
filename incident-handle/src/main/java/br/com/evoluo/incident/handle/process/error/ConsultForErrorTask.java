package br.com.evoluo.incident.handle.process.error;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import br.com.evoluo.incident.handle.commons.SimpleLogger;
import br.com.evoluo.incident.handle.model.IncidentIdentity;

@Component
public class ConsultForErrorTask implements JavaDelegate {

	private static final SimpleLogger log = SimpleLogger.getLogger(ConsultForErrorTask.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.start("execute");
		IncidentIdentity identity = (IncidentIdentity) execution.getVariable("identity");
		boolean hasExists = (execution.getProcessEngineServices().getRuntimeService().createProcessInstanceQuery()
				.processDefinitionId(execution.getProcessDefinitionId()).variableValueEquals("identity", identity)
				.singleResult() == null);
		execution.setVariable("hasExists", hasExists);
		log.end("execute");
	}

}
