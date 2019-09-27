package com.hcl.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

	@Autowired
	UserService userService;
	
	@Autowired
	AccountService accountService;

	@RequestMapping("/")
	public ModelAndView home(ModelAndView model) {
		user user = new user();
		model.addObject("user",user);
		model.setViewName("LoginPage");
		return model;
	}

	@RequestMapping("/login")
	public ModelAndView loginAccount(@ModelAttribute user uss) {
		String pswrd = userService.getUser(uss.getUsername()).getPassword();
		int id = userService.getUser(uss.getUsername()).getId();
		if (uss.getPassword().equals(pswrd)) {
			
		return  new ModelAndView("redirect:/AccountPage1?id=" + id);
		} else {
			return new ModelAndView("redirect:/");
		}
		
	}
	
	@RequestMapping(value = "/AccountPage1")
	public ModelAndView listAccount(ModelAndView model,HttpServletRequest req) {
		List<Accounts> listAccounts = accountService.getAccountsByUserId(Integer.parseInt(req.getParameter("id")));
		model.addObject("listAccount", listAccounts);
		model.setViewName("AccountPage");
		return model;
	}

}
