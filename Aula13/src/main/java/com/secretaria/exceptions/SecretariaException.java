package com.secretaria.exceptions;

public class SecretariaException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public SecretariaException(String message) {
		super(message);
	}
}