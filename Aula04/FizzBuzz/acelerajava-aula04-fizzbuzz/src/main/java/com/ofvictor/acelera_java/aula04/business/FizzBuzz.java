package com.ofvictor.acelera_java.aula04.business;

public class FizzBuzz {
	public static final int LIMITE_INFERIOR = 1;
	public static final int LIMITE_SUPERIOR = 100;
	
	public static String EXPECTED_FIZZ = "fizz";
	public static String EXPECTED_BUZZ = "buzz";
	
	
	public String processNumber(int number) {
		if (number < FizzBuzz.LIMITE_INFERIOR) {
			throw new IllegalArgumentException("Número inferior ao menor do intervalo.");
		}
		
		if (number > FizzBuzz.LIMITE_SUPERIOR) {
			throw new IllegalArgumentException("Número superior ao maior do intervalo.");
		}
		
		StringBuilder retorno = new StringBuilder();
		
		if ((number % 3) == 0) {
			retorno.append(FizzBuzz.EXPECTED_FIZZ);
		}
		
		if ((number % 5) == 0) {
			retorno.append(FizzBuzz.EXPECTED_BUZZ);
		}
		
		return ((retorno.length() == 0)?String.valueOf(number):retorno.toString());
	}
}