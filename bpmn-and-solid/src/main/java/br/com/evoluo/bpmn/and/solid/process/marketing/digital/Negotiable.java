package br.com.evoluo.bpmn.and.solid.process.marketing.digital;

import br.com.evoluo.bpmn.and.solid.process.marketing.digital.exceptions.InvalidLeadException;

public interface Negotiable {
	
	public void validateLead() throws InvalidLeadException;

	public Contractable negotiate();

}
