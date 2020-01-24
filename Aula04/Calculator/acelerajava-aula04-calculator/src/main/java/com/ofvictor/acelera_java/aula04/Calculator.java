package com.ofvictor.acelera_java.aula04;

public class Calculator {
	
	private void validateOperands(Double firstOperand, Double secondOperand) {
		if (firstOperand == null) {
			throw new IllegalArgumentException();
		}
		
		if (secondOperand == null) {
			throw new IllegalArgumentException();
		}
	}
	
	public Double sum(Double firstOperand, Double secondOperand) {
		this.validateOperands(firstOperand, secondOperand);
		
		return firstOperand + secondOperand;
	}
	
	public Double subtract(Double firstOperand, Double secondOperand) {
		this.validateOperands(firstOperand, secondOperand);
		return firstOperand - secondOperand;
	}
	
	public Double multiply(Double firstOperand, Double secondOperand) {
		this.validateOperands(firstOperand, secondOperand);
		
		return firstOperand * secondOperand;
	}
	
	public Double divide(Double firstOperand, Double secondOperand) {
		this.validateOperands(firstOperand, secondOperand);
		
		if (secondOperand == 0.0) {
			throw new IllegalArgumentException();
		}
		
		return firstOperand / secondOperand;
	}
}
