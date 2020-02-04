package com.ofvictor.core.tema15.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ofvictor.core.tema15.business.CashMachine;
import com.ofvictor.core.tema15.exception.CashMachineException;

public class CashMachineTest {
	@Test (expected = CashMachineException.class)
	public void testWithdraw10NotAvailable() {
		// Loading the ATM with notes.
		CashMachine atm = new CashMachine(0,0,0,0);
		
		double valueToWithdraw = 10.0;
		
		atm.getWithdraw().setRequestedValue(valueToWithdraw);
		atm.getNote100().handleWithdraw(atm.getWithdraw());
	}
	
	@Test
	public void testWithdraw10With1Note10() {
		// Loading the ATM with notes.
		CashMachine atm = new CashMachine(0,0,0,1);
		
		double valueToWithdraw = 10.0;
		
		// Testing the amount of R$ 10 notes before the withdraw.
		assertEquals(atm.getNote10().getNoteAmount(),1);
		
		atm.getWithdraw().setRequestedValue(valueToWithdraw);
		atm.getNote100().handleWithdraw(atm.getWithdraw());
		
		// Testing the amount of R$ 10 notes after the withdraw.
		assertEquals(atm.getNote10().getNoteAmount(),0);
		
		// Testing the amount of delivered notes.
		assertEquals(atm.getNote100().getCurrentWithdrawNoteAmount(),0);
		assertEquals(atm.getNote50().getCurrentWithdrawNoteAmount(),0);
		assertEquals(atm.getNote20().getCurrentWithdrawNoteAmount(),0);
		assertEquals(atm.getNote10().getCurrentWithdrawNoteAmount(),1);
	}
	
	@Test
	public void testWithdraw20With1Note20() {
		// Loading the ATM with notes.
		CashMachine atm = new CashMachine(0,0,1,0);
		
		double valueToWithdraw = 20.0;
		
		// Testing the amount of R$ 20 notes before the withdraw.
		assertEquals(atm.getNote20().getNoteAmount(),1);
		
		atm.getWithdraw().setRequestedValue(valueToWithdraw);
		atm.getNote100().handleWithdraw(atm.getWithdraw());
		
		// Testing the amount of R$ 20 notes after the withdraw.
		assertEquals(atm.getNote20().getNoteAmount(),0);
		
		// Testing the amount of delivered notes.
		assertEquals(atm.getNote100().getCurrentWithdrawNoteAmount(),0);
		assertEquals(atm.getNote50().getCurrentWithdrawNoteAmount(),0);
		assertEquals(atm.getNote20().getCurrentWithdrawNoteAmount(),1);
		assertEquals(atm.getNote10().getCurrentWithdrawNoteAmount(),0);
	}
	
	@Test
	public void testWithdraw20With2Note10() {
		// Loading the ATM with notes.
		CashMachine atm = new CashMachine(0,0,0,2);
		
		double valueToWithdraw = 20.0;
		
		// Testing the amount of R$ 10 notes before the withdraw.
		assertEquals(atm.getNote10().getNoteAmount(),2);
		
		atm.getWithdraw().setRequestedValue(valueToWithdraw);
		atm.getNote100().handleWithdraw(atm.getWithdraw());
		
		// Testing the amount of R$ 20 notes after the withdraw.
		assertEquals(atm.getNote20().getNoteAmount(),0);
		
		// Testing the amount of delivered notes.
		assertEquals(atm.getNote100().getCurrentWithdrawNoteAmount(),0);
		assertEquals(atm.getNote50().getCurrentWithdrawNoteAmount(),0);
		assertEquals(atm.getNote20().getCurrentWithdrawNoteAmount(),0);
		assertEquals(atm.getNote10().getCurrentWithdrawNoteAmount(),2);
	}
	
	@Test
	public void testWithdraw50With1Note50() {
		// Loading the ATM with notes.
		CashMachine atm = new CashMachine(0,1,0,0);
		
		double valueToWithdraw = 50.0;
		
		// Testing the amount of R$ 50 notes before the withdraw.
		assertEquals(atm.getNote50().getNoteAmount(),1);
		
		atm.getWithdraw().setRequestedValue(valueToWithdraw);
		atm.getNote100().handleWithdraw(atm.getWithdraw());
		
		// Testing the amount of R$ 50 notes after the withdraw.
		assertEquals(atm.getNote50().getNoteAmount(),0);
		
		// Testing the amount of delivered notes.
		assertEquals(atm.getNote100().getCurrentWithdrawNoteAmount(),0);
		assertEquals(atm.getNote50().getCurrentWithdrawNoteAmount(),1);
		assertEquals(atm.getNote20().getCurrentWithdrawNoteAmount(),0);
		assertEquals(atm.getNote10().getCurrentWithdrawNoteAmount(),0);
	}
	
	@Test
	public void testWithdraw50With1Note20And3Note10() {
		// Loading the ATM with notes.
		CashMachine atm = new CashMachine(0,0,1,5);
		
		double valueToWithdraw = 50.0;
		
		// Testing the amount of R$ 10 and R$ 20 notes before the withdraw.
		assertEquals(atm.getNote20().getNoteAmount(),1);
		assertEquals(atm.getNote10().getNoteAmount(),5);
		
		atm.getWithdraw().setRequestedValue(valueToWithdraw);
		atm.getNote100().handleWithdraw(atm.getWithdraw());
		
		// Testing the amount of R$ 10 and R$ 20 notes after the withdraw.
		assertEquals(atm.getNote20().getNoteAmount(),0);
		assertEquals(atm.getNote10().getNoteAmount(),2);
		
		// Testing the amount of delivered notes.
		assertEquals(atm.getNote100().getCurrentWithdrawNoteAmount(),0);
		assertEquals(atm.getNote50().getCurrentWithdrawNoteAmount(),0);
		assertEquals(atm.getNote20().getCurrentWithdrawNoteAmount(),1);
		assertEquals(atm.getNote10().getCurrentWithdrawNoteAmount(),3);
	}
	
	@Test
	public void testWithdraw100With1Note100() {
		// Loading the ATM with notes.
		CashMachine atm = new CashMachine(1,0,0,0);
		
		double valueToWithdraw = 100.0;
		
		// Testing the amount of R$ 100 notes before the withdraw.
		assertEquals(atm.getNote100().getNoteAmount(),1);
		
		atm.getWithdraw().setRequestedValue(valueToWithdraw);
		atm.getNote100().handleWithdraw(atm.getWithdraw());
		
		// Testing the amount of R$ 100 notes after the withdraw.
		assertEquals(atm.getNote100().getNoteAmount(),0);
		
		// Testing the amount of delivered notes.
		assertEquals(atm.getNote100().getCurrentWithdrawNoteAmount(),1);
		assertEquals(atm.getNote50().getCurrentWithdrawNoteAmount(),0);
		assertEquals(atm.getNote20().getCurrentWithdrawNoteAmount(),0);
		assertEquals(atm.getNote10().getCurrentWithdrawNoteAmount(),0);
	}
	
	@Test
	public void testWithdraw100With2Note50() {
		// Loading the ATM with notes.
		CashMachine atm = new CashMachine(0,3,0,0);
		
		double valueToWithdraw = 100.0;
		
		// Testing the amount of R$ 50 notes before the withdraw.
		assertEquals(atm.getNote50().getNoteAmount(),3);
		
		atm.getWithdraw().setRequestedValue(valueToWithdraw);
		atm.getNote100().handleWithdraw(atm.getWithdraw());
		
		// Testing the amount of R$ 50 notes after the withdraw.
		assertEquals(atm.getNote50().getNoteAmount(),1);
		
		// Testing the amount of delivered notes.
		assertEquals(atm.getNote100().getCurrentWithdrawNoteAmount(),0);
		assertEquals(atm.getNote50().getCurrentWithdrawNoteAmount(),2);
		assertEquals(atm.getNote20().getCurrentWithdrawNoteAmount(),0);
		assertEquals(atm.getNote10().getCurrentWithdrawNoteAmount(),0);
	}
	
	@Test
	public void testWithdraw100With1Note50And2Note20And1Note10() {
		// Loading the ATM with notes.
		CashMachine atm = new CashMachine(0,1,2,3);
		
		double valueToWithdraw = 100.0;
		
		// Testing the amount of notes before the withdraw.
		assertEquals(atm.getNote50().getNoteAmount(),1);
		assertEquals(atm.getNote20().getNoteAmount(),2);
		assertEquals(atm.getNote10().getNoteAmount(),3);
		
		atm.getWithdraw().setRequestedValue(valueToWithdraw);
		atm.getNote100().handleWithdraw(atm.getWithdraw());
		
		// Testing the amount of notes after the withdraw.
		assertEquals(atm.getNote50().getNoteAmount(),0);
		assertEquals(atm.getNote20().getNoteAmount(),0);
		assertEquals(atm.getNote10().getNoteAmount(),2);
		
		// Testing the amount of delivered notes.
		assertEquals(atm.getNote100().getCurrentWithdrawNoteAmount(),0);
		assertEquals(atm.getNote50().getCurrentWithdrawNoteAmount(),1);
		assertEquals(atm.getNote20().getCurrentWithdrawNoteAmount(),2);
		assertEquals(atm.getNote10().getCurrentWithdrawNoteAmount(),1);
	}
	
	@Test
	public void testWithdraw100With1Note50And1Note20And3Note10() {
		// Loading the ATM with notes.
		CashMachine atm = new CashMachine(0,1,1,4);
		
		double valueToWithdraw = 100.0;
		
		// Testing the amount of notes before the withdraw.
		assertEquals(atm.getNote50().getNoteAmount(),1);
		assertEquals(atm.getNote20().getNoteAmount(),1);
		assertEquals(atm.getNote10().getNoteAmount(),4);
		
		atm.getWithdraw().setRequestedValue(valueToWithdraw);
		atm.getNote100().handleWithdraw(atm.getWithdraw());
		
		// Testing the amount of notes after the withdraw.
		assertEquals(atm.getNote50().getNoteAmount(),0);
		assertEquals(atm.getNote20().getNoteAmount(),0);
		assertEquals(atm.getNote10().getNoteAmount(),1);
		
		// Testing the amount of delivered notes.
		assertEquals(atm.getNote100().getCurrentWithdrawNoteAmount(),0);
		assertEquals(atm.getNote50().getCurrentWithdrawNoteAmount(),1);
		assertEquals(atm.getNote20().getCurrentWithdrawNoteAmount(),1);
		assertEquals(atm.getNote10().getCurrentWithdrawNoteAmount(),3);
	}
}