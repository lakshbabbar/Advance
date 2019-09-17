package com.employee.dao;

import java.util.List;

import com.employee.model.Employee;


public interface EmployeeDAO {

	public List<Employee> getAllEmployees();
	
	public List<Employee> getFilteredEmp(String name,char c);
}
