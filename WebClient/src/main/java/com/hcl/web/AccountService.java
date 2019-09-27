package com.hcl.web;

import java.util.List;

public interface AccountService {
	
	public List<Accounts> getAccountsByUserId(int id);
	
	public String addAccount(Accounts accstr);

	public String deleteAccount(int accno);
}
