package br.com.evoluo.bpmn.and.mvc.exceptions;

public class DigitalMarketingException extends Exception {

	private static final long serialVersionUID = 1285051570759020186L;

	public DigitalMarketingException(String message) {
		super(message);
	}

	public DigitalMarketingException(String message, Exception e) {
		super(message, e);
	}

}
