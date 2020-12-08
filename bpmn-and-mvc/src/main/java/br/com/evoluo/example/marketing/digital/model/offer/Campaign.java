package br.com.evoluo.example.marketing.digital.model.offer;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Campaign implements Serializable {

	private static final long serialVersionUID = -6810206002502290248L;

	private String name;
	private String content;
	private String followUpTimerCicle;
	private Date expiration;

}
