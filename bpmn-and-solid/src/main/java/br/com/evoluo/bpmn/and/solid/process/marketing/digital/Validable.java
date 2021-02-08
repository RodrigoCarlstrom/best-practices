package br.com.evoluo.bpmn.and.solid.process.marketing.digital;

import br.com.evoluo.bpmn.and.solid.process.marketing.digital.exceptions.DigitalMarketingException;

public interface Validable {
	
	public void validateOffer() throws DigitalMarketingException;

}
