package br.com.evoluo.example.marketing.digital;

import br.com.evoluo.example.marketing.digital.exceptions.DigitalMarketingException;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidSaleException;

public interface Contractable {
	
	public void validateSale() throws InvalidSaleException;
	
	public Signable generateContract() throws DigitalMarketingException;
	
	public Boolean giveUp();

	public Boolean recurrent();

}
