package br.com.evoluo.example.marketing.digital.services;

import br.com.evoluo.example.marketing.digital.exceptions.InvalidProspectException;
import br.com.evoluo.example.marketing.digital.model.Lead;
import br.com.evoluo.example.marketing.digital.model.Prospect;

public interface FillableService {

	public Lead fillForm(Prospect prospect);

	public void validate(Prospect prospect) throws InvalidProspectException;

}
