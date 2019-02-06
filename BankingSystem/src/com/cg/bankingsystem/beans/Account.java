package com.cg.bankingsystem.beans;
import java.util.*;
public class Account {
private String accountType,accountStatus;
private long accountNumber,pinNumber;
private double accountBalance;
public HashMap<Long,Transactions> transactions;

public Account() {}

public Account(String accountType, long accountNumber, String accountStatus,long pinNumber, double accountBalance,Customer customer) {
	super();
	this.accountType = accountType;
	this.accountNumber = accountNumber;
	this.pinNumber = pinNumber;
	this.accountBalance = accountBalance;
	this.accountStatus=accountStatus;
	this.transactions = transactions;
}

public Account(String accountType, double accountBalance,Customer customer) {
	super();
	this.accountType = accountType;
	this.accountBalance = accountBalance;
	this.transactions = transactions;
}


@Override
public String toString() {
	return "Account [accountType=" + accountType + ", accountStatus=" + accountStatus + ", accountNumber="
			+ accountNumber + ", pinNumber=" + pinNumber + ", accountBalance=" + accountBalance + ", transactions="
			+ transactions + "]";
}

public String getAccountType() {
	return accountType;
}

public void setAccountType(String accountType) {
	this.accountType = accountType;
}

public long getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(long accountNumber) {
	this.accountNumber = accountNumber;
}

public double getAccountBalance() {
	return accountBalance;
}

public void setAccountBalance(double accountBalance) {
	this.accountBalance = accountBalance;
}

public String getAccountStatus() {
	return accountStatus;
}

public void setAccountStatus(String accountStatus) {
	this.accountStatus = accountStatus;
}

public long getPinNumber() {
	return pinNumber;
}

public void setPinNumber(long pinNumber) {
	this.pinNumber = pinNumber;
}

public HashMap<Long,Transactions> getTransactions() {
	return transactions;
}

public void setTransactions(HashMap<Long,Transactions> transactions) {
	this.transactions = transactions;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(accountBalance);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
	result = prime * result + ((accountStatus == null) ? 0 : accountStatus.hashCode());
	result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
	result = prime * result + (int) (pinNumber ^ (pinNumber >>> 32));
	result = prime * result + ((transactions == null) ? 0 : transactions.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Account other = (Account) obj;
	if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
		return false;
	if (accountNumber != other.accountNumber)
		return false;
	if (accountStatus == null) {
		if (other.accountStatus != null)
			return false;
	} else if (!accountStatus.equals(other.accountStatus))
		return false;
	if (accountType == null) {
		if (other.accountType != null)
			return false;
	} else if (!accountType.equals(other.accountType))
		return false;
	if (pinNumber != other.pinNumber)
		return false;
	if (transactions == null) {
		if (other.transactions != null)
			return false;
	} else if (!transactions.equals(other.transactions))
		return false;
	return true;
}

}
