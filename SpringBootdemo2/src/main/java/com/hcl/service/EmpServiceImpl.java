package com.hcl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcl.model.Employee;
import com.hcl.repository.EmployeeRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmployeeRepository emprepository;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = (List<Employee>) emprepository.findAll();
		if (list.size() > 0) {
			return list;
		} else {
			return new ArrayList<Employee>();
		}
	}

	@Override
	public String addEmployees(String empstr) {

		JSONParser jsonParser = new JSONParser();
		String str = "";

		try {
			Object obj = jsonParser.parse(empstr);
			JSONArray emparr = new JSONArray();
			List<Employee> list = new ArrayList<Employee>();
			emparr = (JSONArray) obj;
			for (Object object : emparr) {
				JSONObject employee = (JSONObject) object;
				Employee emp = new Employee();
				long empno = (Long) employee.get("id");
				emp.setId((int) empno);
				emp.setName((String) employee.get("name"));
				double d = (Double) employee.get("salary");
				emp.setSalary(d);
				list.add(emp);

			}
			List<Employee> tempemp = (List<Employee>) emprepository.saveAll(list);
			if (tempemp != null) {
				str = "Employee created successfully";
			} else {
				str = "Not Created";
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;

	}

	@Override
	public String addEmployee(String empstr) {

		JSONParser jsonParser = new JSONParser();
		String str = "";

		try {
			Object obj = jsonParser.parse(empstr);
			JSONArray emparr = new JSONArray();
			emparr = (JSONArray) obj;
			Employee emp = new Employee();
			for (Object object : emparr) {
				JSONObject employee = (JSONObject) object;

				long empno = (Long) employee.get("id");
				emp.setId((int) empno);
				emp.setName((String) employee.get("name"));
				double d = (Double) employee.get("salary");
				emp.setSalary(d);

			}
			Employee tempEmp = emprepository.save(emp);
			if (tempEmp != null) {
				str = "Employee created successfully";
			} else {
				str = "Not Created";
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	@Override
	public String deleteEmployee(int id) {
		boolean b = emprepository.existsById(id);
		if (b == true) {
			emprepository.deleteById(id);
			return "Employee deleted Successfully";
		} else {
			return "Employee Doesn't Exist";
		}
	}

	@Override
	public String deleteEmployees(String empstr) {

		JSONParser jsonParser = new JSONParser();
		String str = "";

		try {
			Object obj = jsonParser.parse(empstr);
			JSONArray emparr = new JSONArray();
			List<Employee> list = new ArrayList<Employee>();
			emparr = (JSONArray) obj;
			for (Object object : emparr) {
				JSONObject employee = (JSONObject) object;
				Employee emp = new Employee();
				long empno = (Long) employee.get("id");
				emp.setId((int) empno);
				emp.setName((String) employee.get("name"));
				double d = (Double) employee.get("salary");
				emp.setSalary(d);
				list.add(emp);
			}
			emprepository.deleteAll(list);
			str = "Employees Deleted Successfully";
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;

	}

	@Override
	public String updateEmployee(String str) {
		JSONParser jsonParser = new JSONParser();
		String str1 = "";

		try {
			Object obj = jsonParser.parse(str);
			JSONArray emparr = new JSONArray();
			emparr = (JSONArray) obj;
			Employee emp = new Employee();
			for (Object object : emparr) {
				JSONObject employee = (JSONObject) object;

				long empno = (Long) employee.get("id");
				emp.setId((int) empno);
				emp.setName((String) employee.get("name"));
				double d = (Double) employee.get("salary");
				emp.setSalary(d);

			}
			boolean b = emprepository.existsById(emp.getId());
			if (b == true) {
				emprepository.deleteById(emp.getId());
				emprepository.save(emp);
				str = "Employee Updated successfully";
			} else {
				str = "Employee Doesn't Exist";
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	@Override
	public String updateEmployees(String empstr) {

		JSONParser jsonParser = new JSONParser();
		String str = "";

		try {
			Object obj = jsonParser.parse(empstr);
			JSONArray emparr = new JSONArray();
			List<Employee> list = new ArrayList<Employee>();
			emparr = (JSONArray) obj;
			for (Object object : emparr) {
				JSONObject employee = (JSONObject) object;
				Employee emp = new Employee();
				long empno = (Long) employee.get("id");
				emp.setId((int) empno);
				emp.setName((String) employee.get("name"));
				double d = (Double) employee.get("salary");
				emp.setSalary(d);
				list.add(emp);
			}
			List<Employee> tempemp = (List<Employee>) emprepository.saveAll(list);
			str = "Employees Updated Successfully";
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;

	}

	@Override
	public Optional<Employee> getEmployees(int id) {
		boolean b = emprepository.existsById(id);
		if(b==true) {
		Optional<Employee> emp = emprepository.findById(id);
		return emp;
		}else {
		return null;
		}
	}
}
