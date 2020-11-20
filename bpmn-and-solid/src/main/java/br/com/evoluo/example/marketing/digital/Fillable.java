package br.com.evoluo.example.marketing.digital;

import br.com.evoluo.example.marketing.digital.exceptions.InvalidProspectException;

public interface Fillable {
	
	public void validadeProspect() throws InvalidProspectException;
	
	public Negotiable fillForm();

}
