package br.com.evoluo.example.marketing.digital;

import br.com.evoluo.example.marketing.digital.exceptions.DigitalMarketingException;

public interface Validable {
	
	public void validateOffer() throws DigitalMarketingException;

}
