package br.com.evoluo.example.marketing.digital.model.prospect;

import java.io.Serializable;

import lombok.Data;

@Data
public class Contact implements Serializable {

	private static final long serialVersionUID = 4372102270327199177L;

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Address address;

}
