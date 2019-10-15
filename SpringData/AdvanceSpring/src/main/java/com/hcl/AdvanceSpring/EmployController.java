package com.hcl.AdvanceSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EmployController {

	@Autowired
	EmployRepository dao;
	
	@RequestMapping("/displayJavaContractors")
	public ModelAndView getJavaContractors() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("EmployeeList",dao.findByDeptAndDesig("dotnet", "programmer"));
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/")
	public ModelAndView getEmployees() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("EmployeeList",dao.findAll());
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/displayJavaContractorswherebasicgreater")
	public ModelAndView getJavaContractorsone() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("EmployeeList",dao.findByDeptDesigAndBasic("dotnet", "programmer"));
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/displayJavaContractorswherenamestartswithB")
	public ModelAndView getJavaContractorstwo() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("EmployeeList",dao.findByBasicAndPattern());
		mv.setViewName("home");
		return mv;
	}
	
}
