package br.com.evoluo.bpmn.and.solid.process.marketing.digital;

import br.com.evoluo.bpmn.and.solid.process.marketing.digital.exceptions.DigitalMarketingException;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.exceptions.InvalidSaleException;

public interface Contractable {
	
	public void validateSale() throws InvalidSaleException;
	
	public Signable generateContract() throws DigitalMarketingException;
	
	public Boolean giveUp();

	public Boolean recurrent();

}
