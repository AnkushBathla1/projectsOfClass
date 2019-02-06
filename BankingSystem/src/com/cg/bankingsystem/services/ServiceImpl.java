package com.cg.bankingsystem.services;
import com.cg.bankingsystem.DbUtil.BankingServiceDbUtil;
import com.cg.bankingsystem.beans.Account;
import java.util.*;
import com.cg.bankingsystem.beans.Customer;
import com.cg.bankingsystem.exceptions.*;
import com.cg.bankingsystem.serviceDao.*;
import com.cg.bankingsystem.beans.Transactions;
public class ServiceImpl implements Services {
	ServiceDaoImpl serviceDaoImpl =new ServiceDaoImpl();
	Account account;
   
	@Override
	public Account createAccount(String accountType,double accountBalance,String fName,String lName,String adharNo,String panNo,String mobileNo) 
	     throws InvalidDateOfBirthException,InvalidAccountTypeException,InvalidAmountException{
	    Account account = new Account(accountType, accountBalance,new Customer(fName,lName,adharNo,panNo,mobileNo));
	    account.transactions = new HashMap<>();
	    account = serviceDaoImpl.save(account);
		return account;
	}
	@Override
	public double withdraw(long accountNumber,long pinNumber,double amount)throws InvalidAccountNumberException,InvalidAmountException,InvalidPinNumberException,AccountBlockedException{
		account = serviceDaoImpl.update(accountNumber);
		if(pinNumber==BankingServiceDbUtil.getPin()) {
			account.setAccountBalance(account.getAccountBalance()-amount);
			 Long transactionId = BankingServiceDbUtil.getTransactionId();
			 Transactions transactions1= new Transactions();
			 transactions1.setTransactionId(transactionId);
			 transactions1.setAmount(amount);
		     transactions1.setTransactionType(BankingServiceDbUtil.getWithdrawTransactionType());
			 account.transactions.put(transactionId,transactions1);
			serviceDaoImpl.save(account);
			
			 System.out.println("Withdraw successful");
		}
		return account.getAccountBalance();
	}
	@Override
	public double deposit(long accountNumber,double amount)throws InvalidAmountException,InvalidAccountNumberException,AccountBlockedException{
		account = serviceDaoImpl.update(accountNumber);
	    account.setAccountBalance(account.getAccountBalance()+amount);
	    Long transactionId = BankingServiceDbUtil.getTransactionId();
	    Transactions transactions= new Transactions();
		transactions.setTransactionId(transactionId);
		transactions.setAmount(amount);
		transactions.setTransactionType(BankingServiceDbUtil.getDepositTransactionType());
		account.transactions.put(transactionId,transactions);

	    serviceDaoImpl.save(account);
	    System.out.println("Deposit successful");
	    return account.getAccountBalance();
	}
	@Override
	public double fundtransfer(long fromAccountNumber,long toAccountNumber,long pinOfWithdrawAccount,double amount) throws InvalidAmountException, InvalidAccountNumberException, InvalidPinNumberException,AccountBlockedException{
		
		withdraw(fromAccountNumber, pinOfWithdrawAccount, amount);
		
		deposit(toAccountNumber,amount);
		
		
		return account.getAccountBalance();
	}
	public List<Account> getAllAccount(){
		return serviceDaoImpl.findAll();
	}
}
