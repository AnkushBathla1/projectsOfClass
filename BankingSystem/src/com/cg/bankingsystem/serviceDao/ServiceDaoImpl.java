package com.cg.bankingsystem.serviceDao;
import com.cg.bankingsystem.DbUtil.BankingServiceDbUtil;
import com.cg.bankingsystem.beans.Account;
import java.util.*;
public class ServiceDaoImpl implements ServiceDao{
	@Override
	public  Account save(Account account)
	{
		account.setAccountNumber(BankingServiceDbUtil.setAccNo());
		account.setAccountStatus(BankingServiceDbUtil.setAccStatus());
		account.setPinNumber(BankingServiceDbUtil.getPin());
		BankingServiceDbUtil.accountInfo.put(account.getAccountNumber(), account);

		return account;
	}
	@Override
	public Account update(long accountNumber)
	{
		return BankingServiceDbUtil.accountInfo.get(accountNumber);
	}
	@Override
	public ArrayList<Account>findAll(){
	ArrayList account = new ArrayList<>(BankingServiceDbUtil.accountInfo.values());
		return account;
	}
	
}
