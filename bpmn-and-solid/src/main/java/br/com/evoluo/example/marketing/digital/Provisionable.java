package br.com.evoluo.example.marketing.digital;

import br.com.evoluo.example.marketing.digital.exceptions.InvalidSignatureException;

public interface Provisionable {
	
	public void validateSignature() throws InvalidSignatureException;
	
	public void provisionService();

}
