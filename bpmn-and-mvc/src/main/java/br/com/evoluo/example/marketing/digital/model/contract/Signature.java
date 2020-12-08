package br.com.evoluo.example.marketing.digital.model.contract;

import java.util.Date;

import lombok.Data;

@Data
public class Signature {
	
	private Date date;
	private String hashCode;

}
