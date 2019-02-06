package com.cg.bankingsystem.services;
import java.util.*;

import com.cg.bankingsystem.beans.Account;
import com.cg.bankingsystem.exceptions.AccountBlockedException;
import com.cg.bankingsystem.exceptions.InvalidAccountNumberException;
import com.cg.bankingsystem.exceptions.InvalidAccountTypeException;
import com.cg.bankingsystem.exceptions.InvalidAmountException;
import com.cg.bankingsystem.exceptions.InvalidDateOfBirthException;
import com.cg.bankingsystem.exceptions.InvalidPinNumberException;

public interface Services {
public Account createAccount(String accountType,double accountBalance,String fName,String lName,String adharNo,String panNo,String mobileNo) 
 throws InvalidDateOfBirthException,InvalidAccountTypeException,InvalidAmountException;
public double deposit(long accountNumber,double amount)
		throws InvalidAmountException,InvalidAccountNumberException,AccountBlockedException;
public double withdraw(long accountNumber,long pinNumber,double amount) 
		throws InvalidAccountNumberException,InvalidAmountException,InvalidPinNumberException,AccountBlockedException;
public double  fundtransfer(long fromAccountNumber,long toAccountNumber,long pinOfWithdrawAccount,double amount) 
		throws InvalidAccountNumberException,InvalidAmountException,InvalidPinNumberException, AccountBlockedException;
public List<Account> getAllAccount();

}