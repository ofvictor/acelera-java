package com.ofvictor.core.tema15.business;

import com.ofvictor.core.tema15.exception.CashMachineException;

public class Note10 extends Note {
	private static final double NOTE_VALUE = 10.0;
	
	public Note10(Note nextNote, long noteAmount) {
		super(nextNote);
		this.noteAmount = noteAmount;
	}
	
	public static double getNoteValue() {
		return Note10.NOTE_VALUE;
	}
	
	@Override
	public void handleWithdraw(Withdraw withdraw) {
		this.currentWithdrawNoteAmount = (long) (withdraw.getRequestedValue() / Note10.NOTE_VALUE);
		
		if (this.currentWithdrawNoteAmount <= this.noteAmount) {
			this.noteAmount -= this.currentWithdrawNoteAmount;
		} else {
			throw new CashMachineException("Requested value exceeds the available amount of notes.");
		}
		
		withdraw.setRequestedValue(withdraw.getRequestedValue() - (Note10.NOTE_VALUE * this.currentWithdrawNoteAmount));
		
		this.dispatchToNext(withdraw);
	}
}