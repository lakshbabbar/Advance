package com.employee.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee implements Serializable{

	private static final long serialVersionUID = -3465813074586302847L;
	
	@Id
	@Column
	private int empno;
	
	@Column
	private String empname;
	
	@Column
	private float salary;
	
	@Column
	private char band;
	
	@Column
	private Date dateofjoin;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public char getBand() {
		return band;
	}

	public void setBand(char band) {
		this.band = band;
	}

	public Date getDateofjoin() {
		return dateofjoin;
	}

	public void setDateofjoin(Date dateofjoin) {
		this.dateofjoin = dateofjoin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
