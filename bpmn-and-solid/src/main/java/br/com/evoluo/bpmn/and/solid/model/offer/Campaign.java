package br.com.evoluo.bpmn.and.solid.model.offer;

import java.io.Serializable;
import java.util.Date;

import br.com.evoluo.bpmn.and.solid.commons.SimpleLogger;
import br.com.evoluo.bpmn.and.solid.commons.ValidateUtils;
import br.com.evoluo.bpmn.and.solid.process.marketing.digital.exceptions.InvalidOfferException;
import lombok.Data;

@Data
public class Campaign implements Serializable {
	
	private static final SimpleLogger log = SimpleLogger.getLogger(Campaign.class.getName());

	private static final long serialVersionUID = -6810206002502290248L;

	private String name;
	private String content;
	private String followUpTimerCicle;
	private Date expiration;

	public void validate() throws InvalidOfferException {
		log.start("validate");
		if (ValidateUtils.isEmpty(this.name))
			throw new InvalidOfferException("Campaign name is empty!");
		if (ValidateUtils.isEmpty(this.content))
			throw new InvalidOfferException("Campaign content is empty!");
		if (ValidateUtils.isEmpty(this.followUpTimerCicle))
			throw new InvalidOfferException("Campaign followUoTimerCicle is empty!");
		if (ValidateUtils.isNull(this.expiration))
			throw new InvalidOfferException("Campaign dueDate is null!");
		if (this.expiration.before(new Date()))
			throw new InvalidOfferException("The campaign's expiration date is in the past!");
		log.end("validate");
	}

}
