package com.ofvictor.core.tema15.business;

import java.util.Objects;

public abstract class Note {
	private Note nextNote;
	protected long noteAmount;
	protected long currentWithdrawNoteAmount;
	
	public Note(Note nextNote) {
		this.nextNote = nextNote;
	}
	
	public abstract void handleWithdraw(Withdraw withdraw);
	
	public long getNoteAmount() {
		return noteAmount;
	}
	
	public void setNoteAmount(long noteAmount) {
		this.noteAmount = noteAmount;
	}
	
	public long getCurrentWithdrawNoteAmount() {
		return currentWithdrawNoteAmount;
	}
	
	public void setCurrentWithdrawNoteAmount(long currentWithdrawNoteAmount) {
		this.currentWithdrawNoteAmount = currentWithdrawNoteAmount;
	}
	
	protected void dispatchToNext(Withdraw withdraw) {
		if (Objects.nonNull(this.nextNote)) this.nextNote.handleWithdraw(withdraw);
	}
}