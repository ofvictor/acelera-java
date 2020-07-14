package com.acelera.tcc.group03.dto;

import com.acelera.tcc.group03.domains.TransactionChannel;

public class TransactionChannelDTO {
	private String name;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public TransactionChannel transformDTOToTransactionChannel() {
		TransactionChannel transactionChannel = new TransactionChannel();
		transactionChannel.setName(this.name);
		return transactionChannel;
	}
}