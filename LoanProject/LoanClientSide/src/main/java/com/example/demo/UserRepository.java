package com.example.demo;

import java.util.List;

public interface UserRepository {
	boolean getAuthentication(User user);
	int addUser(User user);
	int getUserId(User user);
	String register(PersonalTable detail);
	long loanCheck(Loan loan);
	List<Loan> getAllLoan(int id);
	long loanCheckExist(int id);
	public boolean checkout(Loan loan);
	long productCheck(Product product);
	boolean checkoutProduct(Product product);
	long productCheckExist(int productid);
	List<Product> getAllProduct(int userid);
}
