package br.com.evoluo.example.marketing.digital.services.impl;

import org.springframework.stereotype.Service;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.marketing.digital.model.Lead;
import br.com.evoluo.example.marketing.digital.model.Prospect;
import br.com.evoluo.example.marketing.digital.services.FillableService;

@Service
public class FillableServiceImpl implements FillableService {

	SimpleLogger log = SimpleLogger.getLogger(FillableServiceImpl.class.getName());

	@Override
	public Lead fillForm(Prospect prospect) {
		log.start("fillForm");
		Lead lead = new Lead(prospect);
		log.ret("fillForm", lead);
		return lead;
	}

}
