package com.ofvictor.acelera_java.aula04.test;

import static org.junit.Assert.*;

import org.junit.Test;
import com.ofvictor.acelera_java.aula04.Calculator;

public class CalculatorTest {
	private static Calculator CALCULATOR = new Calculator();
	
	@Test (expected = IllegalArgumentException.class)
	public void testIfFirstOperandOfSumEqualsNull() {
		Double firstOperand = null;
		Double secondOperand = null;
		
		CALCULATOR.sum(firstOperand,secondOperand);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testIfSecondOperandOfSumEqualsNull() {
		Double firstOperand = null;
		Double secondOperand = null;
		
		CALCULATOR.sum(firstOperand,secondOperand);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testIfBothOperandsOfSumEqualsNull() {
		Double firstOperand = null;
		Double secondOperand = null;
		
		CALCULATOR.sum(firstOperand,secondOperand);
	}
	
	@Test
	public void testIfSumOperationReturnsOk() {
		Double firstOperand = 3.0;
		Double secondOperand = 7.0;
		Double expected = 10.0;
		
		assertEquals(expected,CALCULATOR.sum(firstOperand,secondOperand));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testIfFirstOperandOfSubtractEqualsNull() {
		Double firstOperand = null;
		Double secondOperand = null;
		
		CALCULATOR.subtract(firstOperand,secondOperand);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testIfSecondOperandOfSubtractEqualsNull() {
		Double firstOperand = null;
		Double secondOperand = null;
		
		CALCULATOR.subtract(firstOperand,secondOperand);
	}
	
	@Test
	public void testIfSubtractBothOperandsPositiveOK() {
		Double firstOperand = 3.0;
		Double secondOperand = 5.0;
		Double expected = -2.0;
		
		assertEquals(expected,CALCULATOR.subtract(firstOperand,secondOperand));
	}
	
	@Test
	public void testIfSubtractPositiveAndNegativeOK() {
		Double firstOperand = 3.0;
		Double secondOperand = -5.0;
		Double expected = 8.0;
		
		assertEquals(expected,CALCULATOR.subtract(firstOperand,secondOperand));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAttemptToDivideByZero() {
		Double firstOperand = 10.0;
		Double secondOperand = 0.0;
		
		CALCULATOR.divide(firstOperand, secondOperand);
	}
	
	@Test
	public void testDivisionFirstOperandZero() {
		Double firstOperand = 0.0;
		Double secondOperand = 1000.0;
		Double expected = 0.0;
		
		assertEquals(expected,CALCULATOR.divide(firstOperand, secondOperand));
	}
	
	@Test
	public void testDivisionNegativeOK() {
		Double firstOperand = -40.0;
		Double secondOperand = -8.0;
		Double expected = 5.0;
		
		assertEquals(expected,CALCULATOR.divide(firstOperand, secondOperand));
	}
	
	@Test
	public void testDivisionOK() {
		Double firstOperand = 25.0;
		Double secondOperand = 4.0;
		Double expected = 6.25;
		
		assertEquals(expected,CALCULATOR.divide(firstOperand, secondOperand));
	}
	
	@Test
	public void testMultiplicationPositiveByPositive() {
		Double firstOperand = 11.0;
		Double secondOperand = 7.0;
		Double expected = 77.0;
		
		assertEquals(expected,CALCULATOR.multiply(firstOperand, secondOperand));
	}
	
	@Test
	public void testMultiplicationZeroByZero() {
		Double firstOperand = 0.0;
		Double secondOperand = 0.0;
		Double expected = 0.0;
		
		assertEquals(expected,CALCULATOR.multiply(firstOperand, secondOperand));
	}
}