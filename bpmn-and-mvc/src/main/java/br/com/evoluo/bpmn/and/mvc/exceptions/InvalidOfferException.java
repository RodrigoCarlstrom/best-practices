package br.com.evoluo.bpmn.and.mvc.exceptions;

public class InvalidOfferException extends DigitalMarketingException {

	private static final long serialVersionUID = 8411216720183304035L;
	
	public InvalidOfferException(String message) {
		super(message);
	}

	public InvalidOfferException(ValidateException e) {
		super(e.getMessage(), e);
	}

}
