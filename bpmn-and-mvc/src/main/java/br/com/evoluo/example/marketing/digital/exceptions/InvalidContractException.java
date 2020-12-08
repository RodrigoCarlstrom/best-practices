package br.com.evoluo.example.marketing.digital.exceptions;

public class InvalidContractException extends DigitalMarketingException {

	private static final long serialVersionUID = 4687241568185353674L;

	public InvalidContractException(String message) {
		super(message);
	}

	public InvalidContractException(String message, InvalidSaleException e) {
		super(message, e);
	}

}
