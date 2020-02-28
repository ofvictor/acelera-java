package com.acelera.tcc.group03.dao;

import com.acelera.tcc.group03.pojo.Bank;

public class BankDAO extends DAO<Bank> {
    @Override
    protected String getSqlString() {
        return "SELECT b FROM Bank b";
    }
    
    @Override
    protected Class<Bank> getClassName() {
        return Bank.class;
    }
}