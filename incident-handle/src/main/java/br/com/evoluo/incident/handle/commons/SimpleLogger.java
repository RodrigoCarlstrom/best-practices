package br.com.evoluo.incident.handle.commons;

import java.util.Arrays;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleLogger {

	private Logger log;

	public SimpleLogger(String className) {
		this.log = LogManager.getLogger(className);
	}

	public static SimpleLogger getLogger(String className) {
		return new SimpleLogger(className);
	}

	public void start(String methodName) {
		StringBuffer buffer = new StringBuffer(methodName).append("() - start");
		log.info(buffer.toString());
	}

	public void start(String methodName, Object... parameters) {
		StringBuffer buffer = new StringBuffer(methodName).append("(");
		Iterator<Object> i = Arrays.stream(parameters).iterator();
		while (i.hasNext()) {
			buffer.append(i.next().toString());
			buffer.append(i.hasNext() ? ", " : ") - end");
		}
		log.info(buffer.toString());
	}

	public void end(String methodName) {
		StringBuffer buffer = new StringBuffer(methodName).append("() - end");
		log.info(buffer.toString());
	}

	public void ret(String methodName, Object ret) {
		StringBuffer buffer = new StringBuffer(methodName).append("() - return: ").append(ret.toString());
		log.info(buffer.toString());
	}

}
