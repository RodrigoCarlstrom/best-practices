package br.com.evoluo.example.marketing.digital.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.evoluo.example.marketing.digital.model.offer.Campaign;
import br.com.evoluo.example.marketing.digital.model.offer.DigitalMarketingStatus;
import lombok.Data;

@Data
public class Offer implements Serializable {

	private static final long serialVersionUID = -6037614396403161428L;

	@NotBlank(message = "Offer recipient is blank!")
	private String recipient;
	@NotNull(message = "Offer status is null!")
	private DigitalMarketingStatus status = DigitalMarketingStatus.UNKNOWED;
	@NotNull(message = "Offer campaign is null")
	private Campaign campaign;

}
