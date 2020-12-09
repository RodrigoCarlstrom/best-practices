package br.com.evoluo.example.marketing.digital.model.offer;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Campaign implements Serializable {

	private static final long serialVersionUID = -6810206002502290248L;

	@NotBlank(message = "Offer campaing name is blanck!")
	private String name;
	private String content;
	@NotNull(message = "Offer campaign followUpTimerCicle is null!")
	private String followUpTimerCicle;
	@NotNull(message = "Offer campaign expriration is null!")
	private Date expiration;

}
