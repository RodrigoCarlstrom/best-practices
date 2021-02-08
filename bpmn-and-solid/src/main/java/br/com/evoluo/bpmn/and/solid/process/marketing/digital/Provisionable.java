package br.com.evoluo.bpmn.and.solid.process.marketing.digital;

import br.com.evoluo.bpmn.and.solid.process.marketing.digital.exceptions.InvalidSignatureException;

public interface Provisionable {
	
	public void validateSignature() throws InvalidSignatureException;
	
	public void provisionService();

}
