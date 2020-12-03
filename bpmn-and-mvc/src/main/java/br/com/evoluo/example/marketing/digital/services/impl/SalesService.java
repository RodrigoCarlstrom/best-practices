package br.com.evoluo.example.marketing.digital.services.impl;

import org.springframework.stereotype.Service;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.marketing.digital.model.Contract;
import br.com.evoluo.example.marketing.digital.model.Offer;
import br.com.evoluo.example.marketing.digital.model.Sale;
import br.com.evoluo.example.marketing.digital.services.SituableService;

@Service
public class SalesService implements SituableService {

	private static final SimpleLogger log = SimpleLogger.getLogger(SalesService.class.getName());

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

}
