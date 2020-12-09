package br.com.evoluo.example.marketing.digital.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.commons.ValidateUtils;
import br.com.evoluo.example.commons.exception.ValidateException;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidProspectException;
import br.com.evoluo.example.marketing.digital.model.Contract;
import br.com.evoluo.example.marketing.digital.model.Lead;
import br.com.evoluo.example.marketing.digital.model.Offer;
import br.com.evoluo.example.marketing.digital.model.Prospect;
import br.com.evoluo.example.marketing.digital.services.FillableService;
import br.com.evoluo.example.marketing.digital.services.SituableService;

@Service
public class SalesService implements SituableService, FillableService {

	private static final SimpleLogger log = SimpleLogger.getLogger(SalesService.class.getName());
	
	@Autowired
	private ValidateUtils validator;

	public void submitContract(Contract contract) {
		log.start("submitContract", contract);
		// TODO: Implementar método de envio de contrato
		log.end("submitContract");
	}

	public void updateFunnel(Offer offer) {
		log.start("updateFunnel", offer);
		// TODO: Implementar o método para atualizar base de dados
		log.end("updateFunnel");
	}

	@Override
	public Lead fillForm(Prospect prospect) {
		log.start("fillForm", prospect);
		Lead lead = new Lead(prospect);
		log.ret("fillForm", lead);
		return lead;
	}

	@Override
	public void validate(Prospect prospect) throws InvalidProspectException {
		log.start("validate", prospect);
		try {
			validator.validate(prospect);
		} catch (ValidateException e) {
			throw new InvalidProspectException(e);
		}
		log.end("validate");
	}
}
