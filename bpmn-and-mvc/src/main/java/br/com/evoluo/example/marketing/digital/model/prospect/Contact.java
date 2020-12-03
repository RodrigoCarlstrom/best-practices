package br.com.evoluo.example.marketing.digital.model.prospect;

import java.io.Serializable;

import br.com.evoluo.example.commons.SimpleLogger;
import br.com.evoluo.example.commons.ValidateUtils;
import br.com.evoluo.example.marketing.digital.exceptions.InvalidProspectException;
import lombok.Data;

@Data
public class Contact implements Serializable {

	private static final SimpleLogger log = SimpleLogger.getLogger(Contact.class.getName());

	private static final long serialVersionUID = 4372102270327199177L;

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Address address;

	public void validate() throws InvalidProspectException {
		log.start("validate");
		if (ValidateUtils.isEmpty(this.firstName))
			throw new InvalidProspectException("Contact firtName is empty");
		log.end("validate");
	}

}
