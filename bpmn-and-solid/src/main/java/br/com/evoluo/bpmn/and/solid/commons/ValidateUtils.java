package br.com.evoluo.bpmn.and.solid.commons;

import org.apache.commons.lang3.StringUtils;

public class ValidateUtils {

	public static boolean isEmpty(String str) {
		return StringUtils.isEmpty(str);
	}

	public static boolean isNull(Object obj) {
		return obj == null;
	}

}
