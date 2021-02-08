package br.com.evoluo.bpmn.and.mvc.exceptions;

public class InvalidProspectException extends DigitalMarketingException {

	private static final long serialVersionUID = -7930590980122852907L;

	public InvalidProspectException(String message) {
		super(message);
	}

	public InvalidProspectException(ValidateException e) {
		super(e.getMessage(), e);
	}

}
