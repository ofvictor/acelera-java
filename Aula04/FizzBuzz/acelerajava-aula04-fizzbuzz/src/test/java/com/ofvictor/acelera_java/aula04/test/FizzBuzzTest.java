package com.ofvictor.acelera_java.aula04.test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.ofvictor.acelera_java.aula04.business.FizzBuzz;

public class FizzBuzzTest {
	private static final FizzBuzz FIZZ_BUZZ = new FizzBuzz();
	
	@Test (expected = IllegalArgumentException.class)
	public void testSeRespeitaLimiteInferior() {
		int numero = FizzBuzz.LIMITE_INFERIOR - 1;
		
		FizzBuzzTest.FIZZ_BUZZ.processNumber(numero);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSeRespeitaLimiteSuperior() {
		int numero = FizzBuzz.LIMITE_SUPERIOR + 1;
		
		FizzBuzzTest.FIZZ_BUZZ.processNumber(numero);
	}
	
	@Test
	public void testSeRestoDaDivisaoPor3ForZeroRetornaFizz() {
		int numero = 3;
		
		String realReturn = FizzBuzzTest.FIZZ_BUZZ.processNumber(numero);
		
		assertEquals(FizzBuzz.EXPECTED_FIZZ,realReturn);
	}
	
	@Test
	public void testSeRestoDaDivisaoPor5ForZeroRetornaBuzz() {
		int numero = 5;
		
		String realReturn = FizzBuzzTest.FIZZ_BUZZ.processNumber(numero);
		
		assertEquals(FizzBuzz.EXPECTED_BUZZ,realReturn);
	}
	
	@Test
	public void testSeRestoDaDivisaoNaoForZeroRetornoNumero() {
		int number = 4;
		
		String realReturn = FizzBuzzTest.FIZZ_BUZZ.processNumber(number);
		
		assertEquals(Integer.toString(number),realReturn);
	}
	
	@Test
	public void testSeRestoDaDivisaoPor3EPor5ForZero() {
		int numero = 15;
		String realReturn = FizzBuzzTest.FIZZ_BUZZ.processNumber(numero);
		
		assertEquals((FizzBuzz.EXPECTED_FIZZ + FizzBuzz.EXPECTED_BUZZ),realReturn);
	}
}