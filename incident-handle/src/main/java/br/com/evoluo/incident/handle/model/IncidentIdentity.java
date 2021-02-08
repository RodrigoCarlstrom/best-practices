package br.com.evoluo.incident.handle.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class IncidentIdentity implements Serializable{

	private static final long serialVersionUID = 8515975999665775367L;

	private String processDefinitionId;
	private String activityId;
	private String incidentMessage;

}
