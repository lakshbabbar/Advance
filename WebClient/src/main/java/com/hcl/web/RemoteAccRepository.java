package com.hcl.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RemoteAccRepository implements AccountService{
	
	@Autowired
	protected RestTemplate restTemplate;
	
	protected String serviceUrl;
	
	public RemoteAccRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	@Override
	public List<Accounts> getAccountsByUserId(int id) {
		Accounts[] accounts = restTemplate.getForObject(serviceUrl+"/accounts/getaccounts/{id}", Accounts[].class,id);
		return Arrays.asList(accounts);
	}

	@Override
	public String addAccount(Accounts accstr) {
		ResponseEntity<String> stt = restTemplate.postForEntity(serviceUrl+"/addaccount", accstr, String.class);
		return stt.getBody();
	}

	@Override
	public String deleteAccount(int accno) {
		ResponseEntity<String> stt = restTemplate.postForEntity(serviceUrl+"deleteaccount/{id}", accno, String.class);
		return stt.getBody();
	}

}
