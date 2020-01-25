package com.ofvictor.acelera_java.aula05.exception;

public class ParametroLocacaoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ParametroLocacaoException(String s) {
        super(s);
    }
}