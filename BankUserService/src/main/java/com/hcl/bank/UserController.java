package com.hcl.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userservice;
	
	@RequestMapping("/getuser/{name}")
	public user getUser(@PathVariable("name") String nam) {
		user us=userservice.getUser(nam);
		return us;
	}
}
