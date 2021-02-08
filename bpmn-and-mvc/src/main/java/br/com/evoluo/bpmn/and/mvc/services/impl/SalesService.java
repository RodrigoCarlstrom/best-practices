package br.com.evoluo.bpmn.and.mvc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.evoluo.bpmn.and.mvc.commons.SimpleLogger;
import br.com.evoluo.bpmn.and.mvc.commons.ValidateUtils;
import br.com.evoluo.bpmn.and.mvc.exceptions.InvalidProspectException;
import br.com.evoluo.bpmn.and.mvc.exceptions.ValidateException;
import br.com.evoluo.bpmn.and.mvc.model.Contract;
import br.com.evoluo.bpmn.and.mvc.model.Lead;
import br.com.evoluo.bpmn.and.mvc.model.Offer;
import br.com.evoluo.bpmn.and.mvc.model.Prospect;
import br.com.evoluo.bpmn.and.mvc.services.FillableService;
import br.com.evoluo.bpmn.and.mvc.services.SituableService;

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
