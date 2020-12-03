package br.com.evoluo.example.marketing.digital.services;

import br.com.evoluo.example.marketing.digital.Contractable;
import br.com.evoluo.example.marketing.digital.Signable;

public interface ContractableService {

	public Signable generateSingleContract(Contractable token);

	public Signable generateRecurrenceContract(Contractable token);

}
