package br.com.evoluo.bpmn.and.solid.services;

import org.springframework.stereotype.Service;

import br.com.evoluo.bpmn.and.solid.commons.SimpleLogger;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.Signable;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.Situable;

@Service
public class SalesService {

	private static final SimpleLogger log = SimpleLogger.getLogger(SalesService.class.getName());

	public void submitContract(Signable contract) {
		log.start("submitContract", contract);
		// TODO: Implementar método de envio de contrato
		log.end("submitContract");
	}

	public void updateFunnel(Situable variable) {
		log.start("updateFunnel");
		// TODO: Implementar o método para atualizar base de dados
		log.end("updateFunnel");
	}

}
