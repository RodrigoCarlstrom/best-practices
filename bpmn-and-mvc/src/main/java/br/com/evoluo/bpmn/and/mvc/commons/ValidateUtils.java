package br.com.evoluo.bpmn.and.mvc.commons;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.evoluo.bpmn.and.mvc.exceptions.ValidateException;

@Component
public class ValidateUtils {

	@Autowired
	private Validator validator;

	public static boolean isEmpty(String str) {
		return StringUtils.isEmpty(str);
	}

	public static boolean isNull(Object obj) {
		return obj == null;
	}

	public void validate(Object bean) throws ValidateException {
		Set<ConstraintViolation<Object>> errors = validator.validate(bean);
		if (errors.size() > 0) {
			StringBuffer message = new StringBuffer();
			errors.forEach(error -> message.append(error.getMessage()).append(" "));
			throw new ValidateException(message.toString());
		}
	}

}
