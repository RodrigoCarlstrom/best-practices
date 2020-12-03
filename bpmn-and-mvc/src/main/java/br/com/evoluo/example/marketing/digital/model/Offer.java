package br.com.evoluo.example.marketing.digital.model;

import java.io.Serializable;

import br.com.evoluo.example.marketing.digital.model.offer.Campaign;
import br.com.evoluo.example.marketing.digital.model.offer.DigitalMarketingStatus;
import lombok.Data;

@Data
public abstract class Offer implements Serializable {

	private static final long serialVersionUID = -6037614396403161428L;

	private String recipient;
	private DigitalMarketingStatus status = DigitalMarketingStatus.UNKNOWED;
	private Campaign campaign;

}
