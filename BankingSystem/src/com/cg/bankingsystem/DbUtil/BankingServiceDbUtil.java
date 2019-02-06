package com.cg.bankingsystem.DbUtil;
import java.util.*;
import com.cg.bankingsystem.beans.*;
public class BankingServiceDbUtil {
public static HashMap<Long,Account> accountInfo = new HashMap<>();
public static long ACCOUNT_NUMBER=151721;
public static String ACCOUNT_STATUS="Active";
public static long PIN_NUMBER =((int)Math.random()*1000);
public static long TRANSACTION_ID=1000;
public static String DEPOSIT_TRANSACTION_TYPE="CREDIT";
public static String WITHDRAW_TRANSACTION_TYPE="DEBIT";
public static long setAccNo() {
	return ++ACCOUNT_NUMBER;
}
public static String setAccStatus()
{
	return ACCOUNT_STATUS;
}
public static long getPin() {
	return ++PIN_NUMBER;
}
public static long getTransactionId(){
	return ++TRANSACTION_ID;
}
public static String getWithdrawTransactionType() {
	return WITHDRAW_TRANSACTION_TYPE;
}
public static String getDepositTransactionType() {
	return DEPOSIT_TRANSACTION_TYPE;
}
}
