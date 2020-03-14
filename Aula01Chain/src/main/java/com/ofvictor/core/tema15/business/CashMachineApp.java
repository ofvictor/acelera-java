package com.ofvictor.core.tema15.business;

import java.text.NumberFormat;

public class CashMachineApp {
	public static void main(String[] args) {
		CashMachine atm = new CashMachine(10,10,20,50);
		
		double[] valuesToWithdraw = {10.0,20.0,60.0,90.0,130.0,200.0,260.0,370.0,420.0,540.0};
		
		for (int i = 0 ; i < valuesToWithdraw.length ; i++) {
			System.out.println("Value to withdraw: " + NumberFormat.getCurrencyInstance().format(valuesToWithdraw[i]));
			atm.getWithdraw().setRequestedValue(valuesToWithdraw[i]);
			atm.getNote100().handleWithdraw(atm.getWithdraw());
			
			System.out.println("Amount of " + NumberFormat.getCurrencyInstance().format(Note100.getNoteValue()) + ": " + atm.getNote100().currentWithdrawNoteAmount);
			System.out.println("Amount of " + NumberFormat.getCurrencyInstance().format(Note50.getNoteValue()) + ": " + atm.getNote50().currentWithdrawNoteAmount);
			System.out.println("Amount of " + NumberFormat.getCurrencyInstance().format(Note20.getNoteValue()) + ": " + atm.getNote20().currentWithdrawNoteAmount);
			System.out.println("Amount of " + NumberFormat.getCurrencyInstance().format(Note10.getNoteValue()) + ": " + atm.getNote10().currentWithdrawNoteAmount);
		}
		
		System.out.println("Remaining notes:");
		System.out.println("- Note R$ 100,00: " + atm.getNote100().getNoteAmount());
		System.out.println("- Note R$  50,00: " + atm.getNote50().getNoteAmount());
		System.out.println("- Note R$  20,00: " + atm.getNote20().getNoteAmount());
		System.out.println("- Note R$  10,00: " + atm.getNote10().getNoteAmount());
	}
}