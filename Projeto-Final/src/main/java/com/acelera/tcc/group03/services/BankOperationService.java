package com.acelera.tcc.group03.services;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.acelera.tcc.group03.domains.CustomerAccount;
import com.acelera.tcc.group03.domains.TransactionAccount;
import com.acelera.tcc.group03.domains.TransactionChannel;
import com.acelera.tcc.group03.domains.TransactionType;
import com.acelera.tcc.group03.exceptions.CustomerAccountInsufficientFundsForWithdraw;
import com.acelera.tcc.group03.exceptions.CustomerAccountNotFound;
import com.acelera.tcc.group03.exceptions.TransactionChannelNotFound;
import com.acelera.tcc.group03.exceptions.TransactionTypeNotFound;
import com.acelera.tcc.group03.requests.AccountBalanceRequest;
import com.acelera.tcc.group03.requests.AccountDepositRequest;
import com.acelera.tcc.group03.requests.AccountStatementRequest;
import com.acelera.tcc.group03.requests.AccountTransferRequest;
import com.acelera.tcc.group03.requests.AccountWithdrawRequest;

@Service
public class BankOperationService {
    private static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);
    
	private TransactionTypeService transactionTypeService;
	private TransactionChannelService transactionChannelService;
	private CustomerAccountService customerAccountService;
	private TransactionAccountService transactionAccountService;
	
	public BankOperationService(
			TransactionTypeService transactionTypeService
			,TransactionChannelService transactionChannelService
			,CustomerAccountService customerAccountService
			,TransactionAccountService transactionAccountService
	) {
		this.transactionTypeService = transactionTypeService;
		this.transactionChannelService = transactionChannelService;
		this.customerAccountService = customerAccountService;
		this.transactionAccountService = transactionAccountService;
	}
	
	public Double getAccountBalance(AccountBalanceRequest accountBalanceRequest) {
		Optional<TransactionType> optionalTransactionType = this.getTransactionType(accountBalanceRequest.getTransactionTypeId());
		Optional<TransactionChannel> optionalTransactionChannel = this.getTransactionChannel(accountBalanceRequest.getTransactionChannelId());
		
		Optional<CustomerAccount> optionalCustomerAccount = this.getCustomerAccount(accountBalanceRequest.getSourceAccountId());
		CustomerAccount customerAccount = optionalCustomerAccount.get();
		
		this.registerTransactionAccount(optionalTransactionType.get(),optionalTransactionChannel.get(),customerAccount,customerAccount.getAccountBalance());
		
		return customerAccount.getAccountBalance();
	}
	
	public CustomerAccount accountDeposit(AccountDepositRequest accountDepositRequest) {
		Optional<TransactionType> optionalTransactionType = this.getTransactionType(accountDepositRequest.getTransactionTypeId());
		Optional<TransactionChannel> optionalTransactionChannel = this.getTransactionChannel(accountDepositRequest.getTransactionChannelId());
		
		Optional<CustomerAccount> optionalCustomerAccount = this.getCustomerAccount(accountDepositRequest.getSourceAccountId());
		CustomerAccount customerAccount = optionalCustomerAccount.get();
		
		customerAccount.setAccountBalance(customerAccount.getAccountBalance() + accountDepositRequest.getAmountToDeposit());
		this.customerAccountService.update(customerAccount);
		
		this.registerTransactionAccount(optionalTransactionType.get(),optionalTransactionChannel.get(),customerAccount,customerAccount.getAccountBalance());
		
		return customerAccount;
	}
	
	public CustomerAccount accountWithdraw(AccountWithdrawRequest accountWithdrawRequest) {
		Optional<TransactionType> optionalTransactionType = this.getTransactionType(accountWithdrawRequest.getTransactionTypeId());
		Optional<TransactionChannel> optionalTransactionChannel = this.getTransactionChannel(accountWithdrawRequest.getTransactionChannelId());
		
		Optional<CustomerAccount> optionalCustomerAccount = this.getCustomerAccount(accountWithdrawRequest.getSourceAccountId());
		CustomerAccount customerAccount = optionalCustomerAccount.get();
		
		if (customerAccount.getAccountBalance() < accountWithdrawRequest.getAmountToWithdraw()) {
			throw new CustomerAccountInsufficientFundsForWithdraw("Insufficient funds (" + BankOperationService.CURRENCY_FORMAT.format(customerAccount.getAccountBalance()) + ") in the Customer Account " + accountWithdrawRequest.getSourceAccountId() + " for the requested Withdraw (" + BankOperationService.CURRENCY_FORMAT.format(accountWithdrawRequest.getAmountToWithdraw()) + ").");
		}
		
		customerAccount.setAccountBalance(customerAccount.getAccountBalance() - accountWithdrawRequest.getAmountToWithdraw());
		this.customerAccountService.update(customerAccount);
		
		this.registerTransactionAccount(optionalTransactionType.get(),optionalTransactionChannel.get(),customerAccount,customerAccount.getAccountBalance());
		
		return customerAccount;
	}
	
	public CustomerAccount transferBetweenAccounts(AccountTransferRequest accountTransferRequest) {
		Optional<TransactionType> optionalTransactionType = this.getTransactionType(accountTransferRequest.getTransactionTypeId());
		Optional<TransactionChannel> optionalTransactionChannel = this.getTransactionChannel(accountTransferRequest.getTransactionChannelId());
		
		Optional<CustomerAccount> sourceOptionalCustomerAccount = this.getCustomerAccount(accountTransferRequest.getSourceAccountId());
		CustomerAccount sourceCustomerAccount = sourceOptionalCustomerAccount.get();
		
		if (sourceCustomerAccount.getAccountBalance() < accountTransferRequest.getAmountToTransfer()) {
			throw new CustomerAccountInsufficientFundsForWithdraw("Insufficient funds (" + BankOperationService.CURRENCY_FORMAT.format(sourceCustomerAccount.getAccountBalance()) + ") in the Customer Account " + accountTransferRequest.getSourceAccountId() + " for the requested Withdraw (" + BankOperationService.CURRENCY_FORMAT.format(accountTransferRequest.getAmountToTransfer()) + ").");
		}
		
		Optional<CustomerAccount> targetOptionalCustomerAccount = this.getCustomerAccount(accountTransferRequest.getTargetAccountId());
		CustomerAccount targetCustomerAccount = targetOptionalCustomerAccount.get();
		
		sourceCustomerAccount.setAccountBalance(sourceCustomerAccount.getAccountBalance() - accountTransferRequest.getAmountToTransfer());
		this.customerAccountService.update(sourceCustomerAccount);
		
		this.registerTransactionAccount(optionalTransactionType.get(),optionalTransactionChannel.get(),sourceCustomerAccount,sourceCustomerAccount.getAccountBalance());
		
		targetCustomerAccount.setAccountBalance(targetCustomerAccount.getAccountBalance() + accountTransferRequest.getAmountToTransfer());
		this.customerAccountService.update(targetCustomerAccount);
		
		this.registerTransactionAccount(optionalTransactionType.get(),optionalTransactionChannel.get(),targetCustomerAccount,targetCustomerAccount.getAccountBalance());
		
		return sourceCustomerAccount;
	}
	
	public List<TransactionAccount> getAccountStatement(AccountStatementRequest accountStatementRequest) {
		Optional<TransactionType> optionalTransactionType = this.getTransactionType(accountStatementRequest.getTransactionTypeId());
		Optional<TransactionChannel> optionalTransactionChannel = this.getTransactionChannel(accountStatementRequest.getTransactionChannelId());
		
		Optional<CustomerAccount> optionalCustomerAccount = this.getCustomerAccount(accountStatementRequest.getSourceAccountId());
		CustomerAccount customerAccount = optionalCustomerAccount.get();
		
		List<TransactionAccount> transactionAccounts = this.transactionAccountService.getForStatement(customerAccount,accountStatementRequest.getAmountOfDays());
		
		this.registerTransactionAccount(optionalTransactionType.get(),optionalTransactionChannel.get(),customerAccount,customerAccount.getAccountBalance());
		
		return transactionAccounts;
	}
	
	private Optional<TransactionType> getTransactionType(Long transactionTypeId) {
		Optional<TransactionType> optionalTransactionType = this.transactionTypeService.getById(transactionTypeId);
		if (!optionalTransactionType.isPresent()) {
			throw new TransactionTypeNotFound("Transaction Type " + transactionTypeId + " not found.");
		}
		return optionalTransactionType;
	}
	
	private Optional<TransactionChannel> getTransactionChannel(Long transactionChannelId) {
		Optional<TransactionChannel> optionalTransactionChannel = this.transactionChannelService.getById(transactionChannelId);
		if (!optionalTransactionChannel.isPresent()) {
			throw new TransactionChannelNotFound("Transaction Channel " + transactionChannelId + " not found.");
		}
		return optionalTransactionChannel;
	}
	
	private Optional<CustomerAccount> getCustomerAccount(Long customerAccountId) {
		Optional<CustomerAccount> optionalCustomerAccount = this.customerAccountService.getById(customerAccountId);
		if (!optionalCustomerAccount.isPresent()) {
			throw new CustomerAccountNotFound("Account " + customerAccountId + " not found.");
		}
		return optionalCustomerAccount;
	}
	
	private void registerTransactionAccount(TransactionType transactionType, TransactionChannel transactionChannel, CustomerAccount customerAccount, Double amount) {
		TransactionAccount transactionAccount = new TransactionAccount();
		
		transactionAccount.setTransactionType(transactionType);
		transactionAccount.setTransactionChannel(transactionChannel);
		transactionAccount.setCustomerAccount(customerAccount);
		transactionAccount.setAmount(amount);
		transactionAccount.setTransactionMoment(LocalDateTime.now());
		
		this.transactionAccountService.create(transactionAccount);
	}
}