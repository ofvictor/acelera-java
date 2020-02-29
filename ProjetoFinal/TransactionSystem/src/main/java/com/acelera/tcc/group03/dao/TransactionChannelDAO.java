package com.acelera.tcc.group03.dao;

import com.acelera.tcc.group03.pojo.TransactionChannel;

public class TransactionChannelDAO extends DAO<TransactionChannel> {
	@Override
	protected String getSqlString() {
		return "SELECT tc FROM TransactionChannel tc";
	}
	
	@Override
	protected Class<TransactionChannel> getClassName() {
		return TransactionChannel.class;
	}
}