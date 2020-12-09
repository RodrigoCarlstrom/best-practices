package br.com.evoluo.example.marketing.digital.exceptions;

import br.com.evoluo.example.commons.exception.ValidateException;

public class InvalidContractException extends DigitalMarketingException {

	private static final long serialVersionUID = 4687241568185353674L;

	public InvalidContractException(ValidateException e) {
		super(e.getMessage(), e);
	}

	public InvalidContractException(String message, InvalidSaleException e) {
		super(message, e);
	}

}
