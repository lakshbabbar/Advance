package com.hcl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Employee;
import com.hcl.service.EmpService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmpService empservice;

	@RequestMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> list = empservice.getAllEmployees();
		return new ResponseEntity<List<Employee>>(list,new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/addemployee")
	public ResponseEntity<String> addEmployee(@RequestBody String empstr){
		return new ResponseEntity<String>(empservice.addEmployee(empstr),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping("/addemployees")
	public ResponseEntity<String> addEmployees(@RequestBody String empstr){
		return new ResponseEntity<String>(empservice.addEmployee(empstr),new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@RequestMapping("{id}/delete")
	public ResponseEntity<String> deleteEmployee(@PathVariable(value="id") int id){
		return new ResponseEntity<String>(empservice.deleteEmployee(id),new HttpHeaders(),HttpStatus.OK);
	}
	
	@RequestMapping("/deleteemployees")
	public ResponseEntity<String> deleteEmployees(@RequestBody String empstr){
		return new ResponseEntity<String>(empservice.deleteEmployees(empstr),new HttpHeaders(),HttpStatus.OK);
	}
	
	@RequestMapping("/updateemployee")
	public ResponseEntity<String> updateEmployee(@RequestBody String empstr){
		return new ResponseEntity<String>(empservice.updateEmployee(empstr),new HttpHeaders(),HttpStatus.OK);
	}
	
	@RequestMapping("/updateemployees")
	public ResponseEntity<String> updateEmployees(@RequestBody String empstr){
		return new ResponseEntity<String>(empservice.updateEmployees(empstr),new HttpHeaders(),HttpStatus.OK);
	}
	
	@RequestMapping("{id}/getemployees")
	public ResponseEntity<Optional<Employee>> getallEmployees(@PathVariable(value="id") int id){
		return new ResponseEntity<Optional<Employee>>(empservice.getEmployees(id),new HttpHeaders(),HttpStatus.OK);
	}
	
}
