package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RestController
@RequestMapping("/")
public class controller {
	
	private static final Logger logger = Logger.getLogger(controller.class);

	public controller() {
		logger.info("Loan Logger Files");
		System.out.println("controller()");
	}
	
	@Autowired
     UserRepository userRepo;
	
	@RequestMapping("/")
	public ModelAndView home(ModelAndView model){
		logger.info("Entering into Client Side home method");
		User user = new User();
		model.addObject("user", user);
		model.setViewName("Login");
		return model;
	}
	@RequestMapping("/authentication")
	public ModelAndView accountList(@ModelAttribute User user, ModelAndView model ) {
		logger.info("Entering into Client Side account list method");
		if(userRepo.getAuthentication(user)) {
			model.addObject("user",user);
			model.addObject("userid",userRepo.getUserId(user));
			model.setViewName("Home");
			return model;
		} else {
			model.addObject("user",user);
			model.addObject("wrong","user Name and Password is Wrong");
			model.setViewName("Login");
			return model;
		}
	}
	
	@RequestMapping("/newuser")
	public ModelAndView newuser(ModelAndView model){
		logger.info("Entering into Client Side new user method");
		User user = new User();
		model.addObject("user", user);
		model.setViewName("NewUser");
		return model;
	}
	
	@RequestMapping("/newdetail")
	public ModelAndView newDetail(@ModelAttribute User user, ModelAndView model){
		logger.info("Entering into Client Side new detail method");
		int id = userRepo.addUser(user);
		PersonalTable detail = new PersonalTable();
		model.addObject("id", id);
		detail.setUserid(id);
		model.addObject("detail", detail);
		model.setViewName("NewForm");
		return model;
	}
	
	@PostMapping("/register" )
	public ModelAndView register(@ModelAttribute PersonalTable detail,  ModelAndView model){
		logger.info("Entering into Client Side register method");
		String str = userRepo.register(detail);
		System.out.println("\n\n\n"+str+"\n\n\n");
		model.addObject("info", str);
		model.setViewName("save");
		return model;
	}
	
	@GetMapping("/applyloanNew/{id}" )
	public ModelAndView applyLoanNew(@PathVariable("id") int id, ModelAndView model){
		logger.info("Entering into Client Side apply new loan method");
		Loan loan = new Loan();
		loan.setUserid(id);
		model.addObject("loan", loan);
		System.out.println("\n\n\n"+loan.getUserid()+"\n\n\n");
		model.setViewName("Loan");
		System.out.println("\n\n\n"+loan+"\n\n\n");
		return model;
	}
	@GetMapping("/loanlist/{id}" )
	public ModelAndView loanList(@PathVariable("id") int id, ModelAndView model){
		logger.info("Entering into Client Side loan list method");
		List<Loan> loanlist = new ArrayList<Loan>();
		Loan loan = new Loan();
		loan.setUserid(id);
		loanlist = userRepo.getAllLoan(id);
		model.addObject("loan",loan);
		model.addObject("loans",loanlist);
		model.setViewName("LoanList");
		return model;
		
	}
	
	@GetMapping("/applyloanExist/{id}/{userid}" )
	public ModelAndView applyLoanExist(@PathVariable("id") int propertyid,@PathVariable("userid") int userid, ModelAndView model){
		logger.info("Entering into Client Side apply on existing loan method");
		long amount = userRepo.loanCheckExist(propertyid);
		Loan loan = new Loan();
		loan.setPropertyid(propertyid);
		loan.setUserid(userid);
		model.addObject("loan",loan);
		model.addObject("amount",amount);
		model.setViewName("Checkout");
		return model;
		
	}
	
	@PostMapping("/checkout" )
	public ModelAndView ckeckout(@ModelAttribute Loan loan, ModelAndView model){
		logger.info("Entering into Client Side checkout method");
		model.addObject("loan",loan);
		if(userRepo.checkout(loan)) {
			model.addObject("confirm","Loan Processed Successfully");
		} else {
			model.addObject("confirm","Loan declined");	
		}
		model.addObject("amount",userRepo.loanCheckExist(loan.getPropertyid()));
		model.setViewName("Checkout");
		return model;
		
	}
	
	@PostMapping("/loancheck" )
	public ModelAndView loanCheck(@ModelAttribute Loan loan,  ModelAndView model){
		logger.info("Entering into Client Side checkloan method");
		System.out.println("\n\n\n"+loan+"\n\n\n");
		model.addObject("loan", loan);
		long amount = userRepo.loanCheck(loan);
		System.out.println("\n\n\n"+amount+"\n\n\n");
		if(amount == -404) {
			model.addObject("exist", "You are not eligible to Take Loan");
			model.setViewName("Loan");
			return model;
		} else {
			model.addObject("amount", amount);
			model.setViewName("Checkout");
			return model;
		}
		
		
	}
	
	@GetMapping("/applyloanNewProduct/{id}" )
	public ModelAndView applyLoanNewProduct(@PathVariable("id") int id, ModelAndView model){
		logger.info("Entering into Client Side apply newloan new product method");
		Product product  = new Product();
		product.setUserid(id);
		model.addObject("product", product);
		System.out.println("\n\n\n"+product.getUserid()+"\n\n\n");
		model.setViewName("NewProduct");
		System.out.println("\n\n\n"+product+"\n\n\n");
		return model;
	}
	
	@PostMapping("/productCheck" )
	public ModelAndView productCheck(@ModelAttribute Product product,  ModelAndView model){
		logger.info("Entering into Client Side productCheck method");
		System.out.println("\n\n\n"+product+"\n\n\n");
		model.addObject("product", product);
		long amount = userRepo.productCheck(product);
		System.out.println("\n\n\n"+amount+"\n\n\n");
		if(amount == -404) {
			model.addObject("exist", "You are not eligible to Take Loan");
			model.setViewName("NewProduct");
			return model;
		} else {
			model.addObject("amount", amount);
			System.out.println("\n\n\n RAghu "+amount+"\n\n\n");
			model.setViewName("CheckoutProduct");
			return model;
		}
		
		
	}
	
	@PostMapping("/checkoutProduct" )
	public ModelAndView ckeckoutProduct(@ModelAttribute Product product, ModelAndView model){
		logger.info("Entering into Client Side checkoutProduct method");
		model.addObject("product",product);
		if(userRepo.checkoutProduct(product)) {
			model.addObject("confirm","Loan Processed Successfully");
		} else {
			model.addObject("confirm","Loan declined");	
		}
		model.addObject("amount",userRepo.productCheckExist(product.getProductid()));
		model.setViewName("CheckoutProduct");
		return model;
		
	}
	
	@GetMapping("/applyloanExistProduct/{id}/{userid}" )
	public ModelAndView applyLoanExistProduct(@PathVariable("id") int productid,@PathVariable("id") int userid, ModelAndView model){
		logger.info("Entering into Client Side apply loan exist product method");
		long amount = userRepo.productCheckExist(productid);
		Product product = new Product();
		product.setProductid(productid);
		product.setUserid(userid);
		model.addObject("product",product);
		model.addObject("amount",amount);
		model.setViewName("CheckoutProduct");
		return model;
		
	}
	
	@GetMapping("/loanlistProduct/{id}" )
	public ModelAndView loanListProduct(@PathVariable("id") int userid, ModelAndView model){
		logger.info("Entering into Client Side loan list product method");
		List<Product> products = new ArrayList<Product>();
		Product product = new Product();
		product.setUserid(userid);
		products = userRepo.getAllProduct(userid);
		model.addObject("product",product);
		model.addObject("products",products);
		model.setViewName("ProductList");
		return model;
		
	}
	
	@GetMapping("/homered/{id}" )
	public ModelAndView homeRed(@PathVariable("id") int userid, ModelAndView model){
		logger.info("Entering into Client Side homeRed method");
		model.addObject("userid",userid);
		model.setViewName("Home");
		return model;
		
	}
	
	
/*	@RequestMapping("/accountDetails")
	public String accountDetails(@RequestParam("number") String id, Model model) {
		model.addAttribute("account", accountRepository.getAccount(id));
		return "accountDetails";
	}*/
}

