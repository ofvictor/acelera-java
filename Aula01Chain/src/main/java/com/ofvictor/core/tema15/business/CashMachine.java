package com.ofvictor.core.tema15.business;

public class CashMachine {
	private Note note10;
	private Note note20;
	private Note note50;
	private Note note100;
	private Withdraw withdraw;
	
	public CashMachine(long amountNotes100, long amountNotes50, long amountNotes20, long amountNotes10) {
		this.note10 = new Note10(null,amountNotes10);
		this.note20 = new Note20(this.note10,amountNotes20);
		this.note50 = new Note50(this.note20,amountNotes50);
		this.note100 = new Note100(this.note50,amountNotes100);
		
		this.withdraw = new Withdraw();
	}
	
	public Note getNote100() {
		return note100;
	}
	
	public Note getNote50() {
		return note50;
	}
	
	public Note getNote20() {
		return note20;
	}
	
	public Note getNote10() {
		return note10;
	}
	
	public Withdraw getWithdraw() {
		return withdraw;
	}
}