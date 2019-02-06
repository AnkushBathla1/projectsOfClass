package com.cg.bankingsystem.serviceDao;

import java.util.List;
import com.cg.bankingsystem.beans.Account;
import com.cg.bankingsystem.beans.Transactions;

public interface TransactionDao {
	Transactions  save(Transactions transaction);
	boolean update(Transactions transaction);
	Transactions findOne(int transactionId);
	List<Transactions> findAll();
}
