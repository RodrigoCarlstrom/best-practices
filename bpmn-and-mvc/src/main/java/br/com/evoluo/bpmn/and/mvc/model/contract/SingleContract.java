package br.com.evoluo.bpmn.and.mvc.model.contract;

import java.io.Serializable;

import br.com.evoluo.bpmn.and.mvc.commons.ValidateUtils;
import br.com.evoluo.bpmn.and.mvc.exceptions.InvalidContractException;
import br.com.evoluo.bpmn.and.mvc.model.Contract;
import br.com.evoluo.bpmn.and.mvc.model.Sale;
import lombok.Data;

@Data
public class SingleContract extends Contract implements Serializable {

	private static final long serialVersionUID = -3460396156303253602L;

	private Double contractValue;
	
	public SingleContract() {
		super();
	}
	
	public SingleContract(Sale sale) {
		super(sale);
		this.contractValue = sale.getValue();
	}

}
