package br.com.evoluo.example.marketing.digital.exceptions;

import br.com.evoluo.example.commons.exception.ValidateException;

public class InvalidSaleException extends DigitalMarketingException {

	private static final long serialVersionUID = -1735316717125166334L;

	public InvalidSaleException(ValidateException e) {
		super(e.getMessage(), e);
	}

}
