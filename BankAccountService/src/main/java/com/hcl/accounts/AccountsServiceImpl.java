package com.hcl.accounts;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsServiceImpl implements AccountService{

	@Autowired
	AccountsRepository accountsRepository;
	
	
	@Override
	public List<Accounts> getAccountsByUserId(int id) {
		List<Accounts> acclist= accountsRepository.getAccountsByuserid(id);
		return acclist;
	}


	@Override
	public String addAccount(Accounts acc) {
			Accounts tempAcc = accountsRepository.save(acc);
			String str = "";
			if (tempAcc != null) {
				str = "Account created successfully";
			} else {
				str = "Not Created";
			}
		return str;
	}


	@Override
	public String deleteAccount(int accno) {
		boolean b = accountsRepository.existsById(accno);
		if (b == true) {
			accountsRepository.deleteById(accno);
			return "Account deleted Successfully";
		} else {
			return "Account Doesn't Exist";
		}
	}

	



	
}
