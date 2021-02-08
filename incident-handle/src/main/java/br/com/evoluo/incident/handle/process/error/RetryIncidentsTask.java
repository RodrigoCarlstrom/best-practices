package br.com.evoluo.incident.handle.process.error;

import java.util.List;

import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.Incident;
import org.camunda.bpm.engine.runtime.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.evoluo.incident.handle.commons.SimpleLogger;
import br.com.evoluo.incident.handle.model.IncidentIdentity;

@Component
public class RetryIncidentsTask implements JavaDelegate {

	private final SimpleLogger log = SimpleLogger.getLogger(RetryIncidentsTask.class.getName());

	@Autowired
	private ManagementService managementService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.start("execute");
		IncidentIdentity identity = (IncidentIdentity) execution.getVariable("identity");
		RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
		List<Incident> incidents = runtimeService.createIncidentQuery()
				.processDefinitionId(identity.getProcessDefinitionId()).activityId(identity.getActivityId())
				.incidentMessage(identity.getIncidentMessage()).list();
		incidents.stream().forEach(incident -> {
			List<Job> jobs = managementService.createJobQuery().jobDefinitionId(incident.getJobDefinitionId()).list();
			jobs.stream().forEach(job -> {
				managementService.setJobRetries(job.getId(), 1);
			});
		});
		log.end("execute");
	}

}
