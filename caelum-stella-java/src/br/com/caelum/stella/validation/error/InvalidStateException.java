package br.com.caelum.stella.validation.error;

import java.util.List;

public class InvalidStateException extends Exception {

	private final List<String> errors;
	
	public InvalidStateException(List<String> errors) {
		this.errors = errors;
	}
	
	public List<String> getErrors(){
		return errors;
	}
	
	private static final long serialVersionUID = 2059717380674816426L;

}
