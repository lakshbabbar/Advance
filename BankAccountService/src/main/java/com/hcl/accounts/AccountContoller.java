package com.hcl.accounts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/accounts")
public class AccountContoller {

	@Autowired
	AccountService accountservice;
	
	@RequestMapping("/getaccounts/{id}")
	public List<Accounts> getAccount(@PathVariable("id") int id) {
		List<Accounts> list=accountservice.getAccountsByUserId(id);
		return list;
	}
	
	@PostMapping("/addaccount")
	public ResponseEntity<String> addEmployee(@RequestBody Accounts acc){
		return new ResponseEntity<String>(accountservice.addAccount(acc),new HttpHeaders(),HttpStatus.OK);
	}
	
	@RequestMapping("deleteaccount/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable(value="id") int accnum){
		return new ResponseEntity<String>(accountservice.deleteAccount(accnum),new HttpHeaders(),HttpStatus.OK);
	}
}
