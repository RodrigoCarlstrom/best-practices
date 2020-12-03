package br.com.evoluo.example.marketing.digital.exceptions;

public class InvalidSignatureException extends DigitalMarketingException {

	private static final long serialVersionUID = -2975485027382208742L;

	public InvalidSignatureException(String message) {
		super(message);
	}

}
