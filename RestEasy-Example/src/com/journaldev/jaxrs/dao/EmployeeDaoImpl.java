package com.journaldev.jaxrs.dao;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.journaldev.jaxrs.model.Employee;
import com.journaldev.jaxrs.model.GenericResponse;

@Path("/employee")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class EmployeeDaoImpl implements EmployeeDao{

	
	private SessionFactory sessionFactory = HibernateUtil.getConnection();
	
	@Override
	public Response addEmployee(Employee e) {
		GenericResponse response = new GenericResponse();
		Session s = sessionFactory.openSession();
		Query q = s.createQuery("from Employee where id = " + e.getId());
		List<Employee> lst = q.list();
		if(lst.size()>0){
			response.setStatus(false);
			response.setMessage("Employee Already Exists");
			response.setErrorCode("EC-01");
			return Response.status(422).entity(response).build();
		}else{
			Transaction t = s.beginTransaction();
			s.save(e);
			t.commit();
			response.setStatus(true);
			response.setMessage("Employee created successfully");
			return Response.ok(response).build();
		}
	}

	@Override
	public Response deleteEmployee(int id) {
		GenericResponse response = new GenericResponse();
		Session s = sessionFactory.openSession();
		Query q = s.createQuery("from Employee where id = " + id);
		List<Employee> lst = q.list();
		if(lst.size()==0){
			response.setStatus(false);
			response.setMessage("Employee Doesn't Exists");
			response.setErrorCode("EC-02");
			return Response.status(404).entity(response).build();
		}else{
		Transaction t = s.beginTransaction();
		Employee emp = lst.get(0);
		s.delete(emp);
		t.commit();
		response.setStatus(true);
		response.setMessage("Employee deleted successfully");
		return Response.ok(response).build();
		}
	}

	@Override
	public Employee getEmployee(int id) {
		SessionFactory sf = HibernateUtil.getConnection();
		Session s = sf.openSession();
		Query q=s.createQuery("from Employ WHERE id = " + id);
		List<Employee> lstEmploy = q.list();
		Employee employ = null;
		if(lstEmploy.size()!=0){
			employ = lstEmploy.get(0);
		} 
		return employ;
	}

	@Override
	public Employee[] getAllEmployees() {
		SessionFactory sf = HibernateUtil.getConnection();
		Session s = sf.openSession();
		Query q = s.createQuery("from Employee");
		List<Employee> list = q.list();
		Employee[] obj = (Employee[]) list.toArray();
		return obj;
	}

}
