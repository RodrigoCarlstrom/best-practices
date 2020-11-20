package br.com.evoluo.example.commons.services;

import org.springframework.stereotype.Service;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.marketing.digital.Signable;
import br.com.evoluo.example.marketing.digital.Situable;

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
