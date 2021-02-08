package br.com.evoluo.bpmn.and.mvc.exceptions;

public class InvalidSaleException extends DigitalMarketingException {

	private static final long serialVersionUID = -1735316717125166334L;

	public InvalidSaleException(ValidateException e) {
		super(e.getMessage(), e);
	}

}
