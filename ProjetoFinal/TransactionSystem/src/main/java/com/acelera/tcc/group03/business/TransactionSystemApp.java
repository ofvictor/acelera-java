package com.acelera.tcc.group03.business;

import java.util.List;

import com.acelera.tcc.group03.dao.BankDAO;
import com.acelera.tcc.group03.dao.CustomerDAO;
import com.acelera.tcc.group03.pojo.Bank;
import com.acelera.tcc.group03.pojo.Customer;
import com.acelera.tcc.group03.pojo.CustomerType;

public class TransactionSystemApp {
	public static void main(String[] args) {
		BankDAO bankDAO = new BankDAO();
		/*
		Bank bank001 = new Bank();
		bank001.setName("Banco do Brasil");
		bank001.setNumber("001");
		bankDAO.create(bank001);
		
		Bank bank104 = new Bank();
		bank104.setName("Caixa Econômica Federal");
		bank104.setNumber("104");
		bankDAO.create(bank104);
		
		Bank bank341 = new Bank();
		bank341.setName("Itaú");
		bank341.setNumber("341");
		bankDAO.create(bank341);
		*/
		List<Bank> listBanks = bankDAO.readAll();
		listBanks.forEach(bank -> System.out.println(bank.toString()));
		
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = new Customer();
		customer.setName("Fábio Victor Pfeiff");
		customer.setType(CustomerType.INDIVIDUAL);
		customer.setTin("123456789");
		customerDAO.create(customer);
		
		List<Customer> listCustomers = customerDAO.readAll();
		listCustomers.forEach(aCustomer -> System.out.println(aCustomer.toString()));
	}
}