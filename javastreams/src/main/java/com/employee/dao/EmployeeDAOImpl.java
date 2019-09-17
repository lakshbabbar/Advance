package com.employee.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private SessionFactory sessionFactory;


	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {

		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getFilteredEmp(String name,char c) {
		if((c=='n')){
			return sessionFactory.getCurrentSession().createQuery("from Employee where empname = '"+ name + "'").list();
		}else{
		return sessionFactory.getCurrentSession().createQuery("from Employee where empname like '"+ name + "%'and band = '" +c+ "'").list();
		}
	}

}
