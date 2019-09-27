package com.hcl.accounts;

import java.util.List;

public interface AccountService {
	
	public List<Accounts> getAccountsByUserId(int id);
	
	public String addAccount(Accounts account);

	public String deleteAccount(int accno);
}
