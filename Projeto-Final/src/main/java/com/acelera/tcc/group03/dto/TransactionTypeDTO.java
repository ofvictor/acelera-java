package com.acelera.tcc.group03.dto;

import com.acelera.tcc.group03.domains.TransactionType;
import com.acelera.tcc.group03.domains.TransactionTypeAction;

public class TransactionTypeDTO {
	private String name;
	
	private TransactionTypeAction action;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public TransactionTypeAction getAction() {
		return this.action;
	}
	
	public void setAction(TransactionTypeAction action) {
		this.action = action;
	}
	
	public TransactionType transformDTOToTransactionType() {
		TransactionType transactionType = new TransactionType();
		transactionType.setName(this.getName());
		transactionType.setAction(this.getAction());
		return transactionType;
	}
}