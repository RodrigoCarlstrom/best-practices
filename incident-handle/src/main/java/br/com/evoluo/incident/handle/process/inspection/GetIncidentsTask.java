package br.com.evoluo.incident.handle.process.inspection;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.Incident;
import org.springframework.stereotype.Component;

import br.com.evoluo.incident.handle.commons.SimpleLogger;
import br.com.evoluo.incident.handle.model.IncidentIdentity;

@Component
public class GetIncidentsTask implements JavaDelegate {

	private final SimpleLogger log = SimpleLogger.getLogger(GetIncidentsTask.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.start("execute");
		List<IncidentIdentity> identities = new ArrayList<IncidentIdentity>();
		List<Incident> incidents = execution.getProcessEngineServices().getRuntimeService().createIncidentQuery()
				.list();
		incidents.forEach(incident -> {
			IncidentIdentity identity = IncidentIdentity.builder()
					.processDefinitionId(incident.getProcessDefinitionId()).activityId(incident.getActivityId())
					.incidentMessage(incident.getIncidentMessage()).build();
			if (!identities.contains(identity)) {
				identities.add(identity);
			}
		});
		execution.setVariable("identities", identities);
		log.end("execute");
	}

}
