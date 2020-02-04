package com.ofvictor.core.tema15.business;

public class Note20 extends Note {
	private static final double NOTE_VALUE = 20.0;
	
	public Note20(Note nextNote, long noteAmount) {
		super(nextNote);
		this.noteAmount = noteAmount;
	}
	
	public static double getNoteValue() {
		return Note20.NOTE_VALUE;
	}
	
	@Override
	public void handleWithdraw(Withdraw withdraw) {
		this.currentWithdrawNoteAmount = (long) (withdraw.getRequestedValue() / Note20.NOTE_VALUE);
		
		if (this.currentWithdrawNoteAmount <= this.noteAmount) {
			this.noteAmount -= this.currentWithdrawNoteAmount;
		} else {
			this.currentWithdrawNoteAmount = this.noteAmount;
			this.noteAmount = 0;
		}
		
		withdraw.setRequestedValue(withdraw.getRequestedValue() - (Note20.NOTE_VALUE * this.currentWithdrawNoteAmount));
		
		this.dispatchToNext(withdraw);
	}
}