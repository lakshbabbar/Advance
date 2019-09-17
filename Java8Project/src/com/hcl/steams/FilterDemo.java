package com.hcl.steams;

import java.util.ArrayList;
import java.util.List;

public class FilterDemo {
public static void main(String[] args) {
	

	List<Employee> list = new ArrayList<>();
	list.add(new Employee(10,"Apple",1212f,'E'));
	list.add(new Employee(20,"Banana",4233f,'M'));
	list.add(new Employee(30,"Carrot",5673f,'M'));
	list.add(new Employee(40,"Dates",4567f,'C'));
	list.add(new Employee(50,"Apricot",1251f,'M'));
	
	list.stream().filter((emp) -> emp.getEmpName().startsWith("A")).forEach((arg) -> {System.out.println(arg.getEmpName());});
	
	list.stream().filter((emp1) -> (emp1.getBand()=='M')).forEach((arg) -> {System.out.println(arg.getEmpName());});
}
}
