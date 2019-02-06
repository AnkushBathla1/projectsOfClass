package com.cg.bankingsystem.serviceDao;
import com.cg.bankingsystem.beans.*;
import java.util.*;
public interface ServiceDao {

	public Account save(Account account);
	public Account update(long accountNumber);
	public List<Account>findAll();
}
