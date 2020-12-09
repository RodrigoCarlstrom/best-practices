package br.com.evoluo.example.marketing.digital.exceptions;

import br.com.evoluo.example.commons.exception.ValidateException;

public class InvalidOfferException extends DigitalMarketingException {

	private static final long serialVersionUID = 8411216720183304035L;
	
	public InvalidOfferException(String message) {
		super(message);
	}

	public InvalidOfferException(ValidateException e) {
		super(e.getMessage(), e);
	}

}
