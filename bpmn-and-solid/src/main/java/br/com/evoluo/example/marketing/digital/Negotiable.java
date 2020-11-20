package br.com.evoluo.example.marketing.digital;

import br.com.evoluo.example.marketing.digital.exceptions.InvalidLeadException;

public interface Negotiable {
	
	public void validateLead() throws InvalidLeadException;

	public Contractable negotiate();

}
