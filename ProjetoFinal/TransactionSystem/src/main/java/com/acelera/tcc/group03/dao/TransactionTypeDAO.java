package com.acelera.tcc.group03.dao;

import com.acelera.tcc.group03.pojo.TransactionType;

public class TransactionTypeDAO extends DAO<TransactionType> {
	@Override
	protected String getSqlString() {
		return "SELECT tt FROM TransactionType tt";
	}
	
	@Override
	protected Class<TransactionType> getClassName() {
		return TransactionType.class;
	}
}