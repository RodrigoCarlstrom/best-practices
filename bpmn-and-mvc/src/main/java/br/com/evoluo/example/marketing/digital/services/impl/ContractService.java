package br.com.evoluo.example.marketing.digital.services.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.evoluo.example.commons.SimpleLogger;
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

}
