package com.employee.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value = "/")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		List<Employee> listEmployee = employeeService.getAllEmployees();
		model.addObject("searchemployee",new Employee());
		model.addObject("listEmployee", listEmployee);
		model.setViewName("home");
		return model;
	}
	
	
	@RequestMapping(value = "filter", method = RequestMethod.POST)
	public ModelAndView filterEmployee(ModelAndView model,@ModelAttribute Employee searchattribute) {
		List<Employee> listfiltered = employeeService.getFilteredEmployees(searchattribute.getEmpname(),searchattribute.getBand());
		model.addObject("searchemployee", new Employee());
		model.addObject("listEmployee", listfiltered);
		model.setViewName("home");
		return model;
	}
	
}
