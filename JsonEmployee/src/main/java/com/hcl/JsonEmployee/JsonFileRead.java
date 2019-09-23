package com.hcl.JsonEmployee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.hcl.model.Employee;

public class JsonFileRead {

	public static void main(String[] args) {
		JSONParser parse = new JSONParser();
		List<Employee> list = new ArrayList();
		try {
			FileReader reader = new FileReader("C:/hcljava/Mode2.6/Employee.json");
		    Object obj1 = parse.parse(reader);
		    
		    JSONObject employeeList = (JSONObject) obj1;
		    Object obj2 = employeeList.get("Employees");
		    
		    JSONObject empobj = (JSONObject)obj2;
		    obj2 = empobj.get("Employee");
		    
		    JSONArray arrr =(JSONArray)obj2;
		    for (Object obj : arrr) {
				JSONObject jsonobj = (JSONObject)obj;
				Employee emp = new Employee();
				 Object no = jsonobj.get("empno");
				 long i = (long)no;
				 int i1=(int)i;
				 emp.setEmpno(i1);
				 Object name = jsonobj.get("empname");  
				 String s=(String)name;
				 emp.setEmpname(s);
				 Object salary = jsonobj.get("salary");  
				 long d = (long)salary;
				 emp.setSalary(d);
				 Object band = jsonobj.get("band");
				 String s1 = (String)band;
				 char c = s1.charAt(0);
				 emp.setBand(c);
				 Object date1 = jsonobj.get("dateofjoin");
				 String dt = (String)date1;
				 Date date11=Date.valueOf(dt);
				 emp.setDateofjoin(date11);
				 list.add(emp);
			}
		    
		    list.forEach((Employee emp1) -> System.out.println(emp1.getEmpno() + " " + emp1.getEmpname() + " "
					 + emp1.getSalary() + " " + emp1.getBand() + " " + emp1.getDateofjoin()));
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {  
			e.printStackTrace();
		}
		
			
		}
	    
	}

