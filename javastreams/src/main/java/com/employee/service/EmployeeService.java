package com.employee.service;

import java.util.List;

import com.employee.model.Employee;


public interface EmployeeService {

	public List<Employee> getAllEmployees();
	
	public List<Employee> getFilteredEmployees(String name,char c);
}
