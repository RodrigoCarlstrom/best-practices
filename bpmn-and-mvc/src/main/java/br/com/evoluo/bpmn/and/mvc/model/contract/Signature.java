package br.com.evoluo.bpmn.and.mvc.model.contract;

import java.util.Date;

import lombok.Data;

@Data
public class Signature {
	
	private Date date;
	private String hashCode;

}
