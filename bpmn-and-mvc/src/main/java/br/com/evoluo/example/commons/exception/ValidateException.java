package br.com.evoluo.example.commons.exception;

import br.com.evoluo.example.marketing.digital.exceptions.DigitalMarketingException;

public class ValidateException extends DigitalMarketingException {

	private static final long serialVersionUID = 8702008986537546874L;

	public ValidateException(String message) {
		super(message);
	}
}
