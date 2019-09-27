package com.hcl.bank;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

	@Autowired 
	UserRepository userrepository;
	
	@Override
	public user getUser(String name) {
	
		List<user> list = new ArrayList<user>();
		list=userrepository.getUserByusername(name);
		user us = list.get(0);
		return us;
	}

	
}
