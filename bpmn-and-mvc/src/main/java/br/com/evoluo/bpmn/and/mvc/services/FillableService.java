package br.com.evoluo.bpmn.and.mvc.services;

import br.com.evoluo.bpmn.and.mvc.exceptions.InvalidProspectException;
import br.com.evoluo.bpmn.and.mvc.model.Lead;
import br.com.evoluo.bpmn.and.mvc.model.Prospect;

public interface FillableService {

	public Lead fillForm(Prospect prospect);

	public void validate(Prospect prospect) throws InvalidProspectException;

}
