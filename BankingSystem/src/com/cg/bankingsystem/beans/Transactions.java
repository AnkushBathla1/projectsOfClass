package com.cg.bankingsystem.beans;

public class Transactions {
long transactionId;
double amount;
String transactionType;
public Transactions() {}
public Transactions(long transactionId,String transactionType) {
	super();
	this.transactionId = transactionId;
	this.amount = amount;
	this.transactionType = transactionType;
}
public Transactions(long transactionId, long amount, String transactionType) {
	super();
	this.transactionId = transactionId;
	this.amount =  amount;
	this.transactionType = transactionType;
}
public long getTransactionId() {
	return transactionId;
}
public void setTransactionId(long transactionId) {
	this.transactionId = transactionId;
}
public double getAmount() {
	return  amount;
}
public void setAmount(double  amount) {
	this. amount =  amount;
}
public String getTransactionType() {
	return transactionType;
}
public void setTransactionType(String transactionType) {
	this.transactionType = transactionType;
}
@Override
public String toString() {
	return "Transactions [transactionId=" + transactionId + ", amount=" + amount + ", transactionType="
			+ transactionType + "]";
}


}
