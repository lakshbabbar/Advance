package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;





public class RemoteUserRepository implements UserRepository{
	@Autowired
	protected RestTemplate restTemplate;

	protected int id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	protected String serviceUrl;
	
	public RemoteUserRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
		
		System.out.println("\n\n\n\n\n"+this.serviceUrl+"\n\n\n\n");
	}

	@Override
	public boolean getAuthentication(User user) {
		User user1 = restTemplate.getForObject(serviceUrl+"/User/getuser/"+user.getUsername(), User.class);
		this.id = user1.getUserid();
		System.out.println("\n\n\n"+user1+"\n\n\n");
		 if(user1 != null && user.getUsername().equals(user1.getUsername()) && user.getPassword().equals(user1.getPassword())) {
			 this.id=user1.getUserid();
			 return true;
		  } else return false;
	}

	@Override
	public String register(PersonalTable detail) {
		System.out.println("\n\n\n"+detail+"\n\n\n");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<PersonalTable> request = new HttpEntity<>(detail,headers);
		ResponseEntity<String> str = restTemplate.postForEntity(serviceUrl+"/User/savePersonalData", request, String.class);
		System.out.println("\n\n\n"+str.getBody()+"\n\n\n");
		return str.getBody();
	}

	@Override
	public int addUser(User user) {
		System.out.println("\n\n\n"+user+"\n\n\n");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> request = new HttpEntity<>(user,headers);
		ResponseEntity<Integer> str = restTemplate.postForEntity(serviceUrl+"/User/saveUser", request, Integer.class);
		System.out.println("\n\n\n"+str.getBody()+"\n\n\n");
		return str.getBody();
	}

	@Override
	public long loanCheck(Loan loan) {
		System.out.println("\n\n\n"+loan+"\n\n\n");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Loan> request = new HttpEntity<>(loan,headers);
		ResponseEntity<Long> str = restTemplate.postForEntity(serviceUrl+"/User/knockUser", request, Long.class);
		System.out.println("\n\n\n"+str.getBody()+"\n\n\n");
		return str.getBody();
	}

	@Override
	public int getUserId(User user) {
		User user1 = restTemplate.getForObject(serviceUrl+"/User/getuser/"+user.getUsername(), User.class);
		return user1.getUserid();
	}

	@Override
	public List<Loan> getAllLoan(int id) {
			@SuppressWarnings("unchecked")
			List<Loan> loanlist = restTemplate.getForObject(serviceUrl+"/User/getLoanDetails/"+id, List.class);
			return loanlist;
	}

	@Override
	public long loanCheckExist(int id) {
		System.out.println("\n\n\n"+id+"\n\n\n");
		long str = restTemplate.getForObject(serviceUrl+"/User/ExistingUser/"+id, Long.class);
		return str;
	}

	@Override
	public boolean checkout(Loan loan) {
		System.out.println("\n\n\n"+loan+"\n\n\n");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Loan> request = new HttpEntity<>(loan,headers);
		ResponseEntity<Boolean> str = restTemplate.postForEntity(serviceUrl+"/User/ExistingLoanDone", request, Boolean.class);
		System.out.println("\n\n\n"+str.getBody()+"\n\n\n");
		return str.getBody();
	}

	@Override
	public long productCheck(Product product) {
		System.out.println("\n\n\n Remote "+product+"\n\n\n");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Product> request = new HttpEntity<>(product,headers);
		ResponseEntity<Long> str = restTemplate.postForEntity(serviceUrl+"/User/productLoan", request, Long.class);
		System.out.println("\n\n\n"+str.getBody()+"\n\n\n");
		return str.getBody();
	}

	@Override
	public boolean checkoutProduct(Product product) {
		System.out.println("\n\n\n checkoutProduct "+product+"\n\n\n");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Product> request = new HttpEntity<>(product,headers);
		ResponseEntity<Boolean> str = restTemplate.postForEntity(serviceUrl+"/User/ApplyProductLoan", request, Boolean.class);
		System.out.println("\n\n\n"+str.getBody()+"\n\n\n");
		return str.getBody();
	}

	@Override
	public long productCheckExist(int productid) {
		long str = restTemplate.getForObject(serviceUrl+"/User/ExistingProductLoan/"+productid, Long.class);
		return str;
	}

	@Override
	public List<Product> getAllProduct(int userid) {
		@SuppressWarnings("unchecked")
		List<Product> products = restTemplate.getForObject(serviceUrl+"/User/getProductDetails/"+userid, List.class);
		return products;
	}

	

	
}
