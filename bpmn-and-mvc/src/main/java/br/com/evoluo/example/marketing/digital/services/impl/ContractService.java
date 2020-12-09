package br.com.evoluo.example.marketing.digital.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.commons.ValidateUtils;
import br.com.evoluo.example.commons.exception.ValidateException;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidContractException;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidSaleException;
import br.com.evoluo.example.marketing.digital.model.Contract;
import br.com.evoluo.example.marketing.digital.model.Sale;
import br.com.evoluo.example.marketing.digital.model.contract.RecurringContract;
import br.com.evoluo.example.marketing.digital.model.contract.Signature;
import br.com.evoluo.example.marketing.digital.model.contract.SingleContract;
import br.com.evoluo.example.marketing.digital.services.ContractableService;
import br.com.evoluo.example.marketing.digital.services.SignableService;

@Service
public class ContractService implements ContractableService,  SignableService {

	SimpleLogger log = SimpleLogger.getLogger(ContractService.class.getName());
	
	@Autowired
	private ValidateUtils validator;

	@Override
	public SingleContract generateSingleContract(Sale sale) {
		log.start("generateSingleContract", sale);
		SingleContract contract = new SingleContract(sale);
		log.ret("generateSingleContract", contract);
		return contract;
	}

	@Override
	public RecurringContract generateRecurrenceContract(Sale sale) {
		log.start("generateRecurrenceContract", sale);
		RecurringContract contract = new RecurringContract(sale);
		log.ret("generateRecurrenceContract", contract);
		return contract;
	}

	@Override
	public void submitContract(Contract contract) {
		log.start("submitContract", contract);
		// TODO: Impemenar o envio do contrato
		log.ret("submitContract", contract);
	}

	@Override
	public Contract receiveSubscription(Contract contract) {
		log.start("receiveSubscription", contract);
		Signature siganure = new Signature();
		siganure.setDate(new Date());
		siganure.setHashCode(String.valueOf(Math.random() * 10000));
		contract.setSignature(siganure);
		log.ret("receiveSubscription", contract);
		return contract;
	}

	@Override
	public void validate(Contract contract) throws InvalidContractException {
		log.start("validate", contract);
		try {
			validator.validate(contract);
		} catch (ValidateException e) {
			throw new InvalidContractException(e);
		}
		log.end("validate");
	}

	@Override
	public void validate(Sale sale) throws InvalidSaleException {
		log.start("validate", sale);
		try {
			validator.validate(sale);
		} catch (ValidateException e) {
			throw new InvalidSaleException(e);
		}
		log.end("validate");
	}

}
