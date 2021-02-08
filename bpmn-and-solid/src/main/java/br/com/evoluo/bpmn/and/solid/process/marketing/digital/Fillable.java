package br.com.evoluo.bpmn.and.solid.process.marketing.digital;

import br.com.evoluo.bpmn.and.solid.process.marketing.digital.exceptions.InvalidProspectException;

public interface Fillable {
	
	public void validadeProspect() throws InvalidProspectException;
	
	public Negotiable fillForm();

}
