package com.hcl.steams;

import java.util.ArrayList;
import java.util.List;

public class CountDemo3 {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(10,"Apple",1212f,'E'));
		list.add(new Employee(20,"Banana",4233f,'M'));
		list.add(new Employee(30,"Carrot",5673f,'M'));
		list.add(new Employee(40,"Dates",4567f,'C'));
		list.add(new Employee(50,"Apricot",1251f,'M'));
		Long noOfRecords = list.stream().count();
		System.out.println(noOfRecords);
		
		Long empsalGt3000 = list.stream().filter((var) -> var.getSalary() > 3000).count();
		System.out.println(empsalGt3000);
		
		Long empsalgt3000man = list.stream().filter( (var) -> var.getSalary()>3000).filter(var -> var.getBand()=='M').count();
		System.out.println(empsalgt3000man);
		
		Long empsalgt3000man1 = list.stream().filter( (var) -> var.getSalary()>3000).filter((var) -> var.getSalary()<4500).filter(var -> var.getBand()=='M').count();
		System.out.println(empsalgt3000man1);
	}
}
