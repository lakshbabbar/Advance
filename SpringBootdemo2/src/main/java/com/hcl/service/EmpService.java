package com.hcl.service;

import java.util.List;
import java.util.Optional;

import com.hcl.model.Employee;

public interface EmpService {

	public List<Employee> getAllEmployees();
	
	public String addEmployee(String empstr);
	
	public String addEmployees(String empstr);

	public String deleteEmployee(int id);
	
	public String deleteEmployees(String empstr);
	
	public String updateEmployee(String str);
	
	public String updateEmployees(String str);
	
	public Optional<Employee> getEmployees(int id);
	
}
