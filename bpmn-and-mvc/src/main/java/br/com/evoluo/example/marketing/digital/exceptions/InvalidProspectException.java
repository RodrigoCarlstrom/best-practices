package br.com.evoluo.example.marketing.digital.exceptions;

import br.com.evoluo.example.commons.exception.ValidateException;

public class InvalidProspectException extends DigitalMarketingException {

	private static final long serialVersionUID = -7930590980122852907L;

	public InvalidProspectException(String message) {
		super(message);
	}

	public InvalidProspectException(ValidateException e) {
		super(e.getMessage(), e);
	}

}
