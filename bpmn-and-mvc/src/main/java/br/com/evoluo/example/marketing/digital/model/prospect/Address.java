package br.com.evoluo.example.marketing.digital.model.prospect;

import java.io.Serializable;

import lombok.Data;

@Data
public class Address implements Serializable {
	
	private static final long serialVersionUID = -3663603897778480269L;
	
	private String street;
	private String city;
	private String state;
	private Integer zipCode;

}
