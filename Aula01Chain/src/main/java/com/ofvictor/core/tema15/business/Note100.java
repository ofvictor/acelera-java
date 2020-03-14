package com.ofvictor.core.tema15.business;

public class Note100 extends Note {
	private static final double NOTE_VALUE = 100.0;
	
	public Note100(Note nextNote, long noteAmount) {
		super(nextNote);
		this.noteAmount = noteAmount;
	}
	
	public static double getNoteValue() {
		return Note100.NOTE_VALUE;
	}
	
	@Override
	public void handleWithdraw(Withdraw withdraw) {
		this.currentWithdrawNoteAmount = (long) (withdraw.getRequestedValue() / Note100.NOTE_VALUE);
		
		if (this.currentWithdrawNoteAmount <= this.noteAmount) {
			this.noteAmount -= this.currentWithdrawNoteAmount;
		} else {
			this.currentWithdrawNoteAmount = this.noteAmount;
			this.noteAmount = 0;
		}
		
		withdraw.setRequestedValue(withdraw.getRequestedValue() - (Note100.NOTE_VALUE * this.currentWithdrawNoteAmount));
		
		this.dispatchToNext(withdraw);
	}
}