package com.acelera.tcc.group03.dao;

import com.acelera.tcc.group03.pojo.Agency;

public class AgencyDAO extends DAO<Agency> {
	@Override
	protected String getSqlString() {
		return "SELECT a FROM Agency a";
	}
	
	@Override
	protected Class<Agency> getClassName() {
		return Agency.class;
	}
}