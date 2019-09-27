package com.hcl.bank;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<user, Integer>{

	public List<user> getUserByusername(String name);
	
}
