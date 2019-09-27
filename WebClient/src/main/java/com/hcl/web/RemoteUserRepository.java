package com.hcl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class RemoteUserRepository implements UserService{

	@Autowired
	protected RestTemplate restTemplate;
	
	protected String serviceUrl;
	
	public RemoteUserRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	
	@Override
	public user getUser(String name) {
		return restTemplate.getForObject(serviceUrl + "/user/getuser/{name}", user.class , name);
	}

}
