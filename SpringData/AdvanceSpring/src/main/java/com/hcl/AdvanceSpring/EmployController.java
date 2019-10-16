package com.hcl.AdvanceSpring;

import java.util.List;

import javax.print.attribute.standard.PageRanges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EmployController {

	@Autowired
	EmployRepository dao;
	
	int qw = 2;
	
	@RequestMapping("/displayJavaContractors")
	public ModelAndView getJavaContractors() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("EmployeeList",dao.findByDeptAndDesig("dotnet", "programmer"));
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/")
	public ModelAndView getEmployees() {
		ModelAndView mv = new ModelAndView();
		List<Employ> emplist = (List<Employ>) dao.findAll();
		mv.addObject("EmployeeList",emplist);
		mv.addObject("pagesize",qw);
		mv.addObject("totalrecords",emplist.size());
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/displayJavaContractorswherebasicgreater")
	public ModelAndView getJavaContractorsone() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("EmployeeList",dao.findByDeptDesigAndBasic("dotnet", "programmer"));
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/displayJavaContractorswherenamestartswithB")
	public ModelAndView getJavaContractorstwo() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("EmployeeList",dao.findByBasicAndPattern(Sort.unsorted()));
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/displayAllSortBYDesig")
	public ModelAndView displayAllSortByDesig1() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("EmployeeList",dao.findAll(Sort.by("desig")));
		mv.setViewName("home");
		return mv;
		
	}
	
	
	@RequestMapping("/displayAllSortBYDesigInDesc")
	public ModelAndView displayAllSortByDesigInDesc() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("EmployeeList",dao.findAll(Sort.by("desig").descending()));
		mv.setViewName("home");
		return mv;
		
	}
	
	@RequestMapping("/displayAllSortBYSalaryDescDeptDesc")
	public ModelAndView displayAllSortBYSalaryDescDeptDesc() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("EmployeeList",dao.findAll(Sort.by(Sort.Order.desc("basic"),Sort.Order.desc("dept"))));
		mv.setViewName("home");
		return mv;
		
	}
	

	@RequestMapping("/displayDotnetEmployeesSortBYSalaryDesc")
	public ModelAndView displayDotnetEmployeesSortBYSalaryDesc() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("EmployeeList",dao.findByDeptAndDesig("dotnet", "programmer",Sort.by("basic").descending()));
		mv.setViewName("home");
		return mv;	
	}
	
	
	@RequestMapping("/displayJavaContractorswherenamestartswithBSortedBySalaryDesc")
	public ModelAndView displayJavaContractorswherenamestartswithBSortedBySalaryDesc() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("EmployeeList",dao.findByBasicAndPattern(Sort.by("basic").descending()));
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/displayAll/page/{pageno}")
	public ModelAndView displayAllSortByDesig(@PathVariable("pageno")int pageno) {
		ModelAndView mv = new ModelAndView();
//		List<Employ> emplist = (List<Employ>) dao.findAll();
//		int length = emplist.size();
//		int hh = 5;
//		if(hh>length) {
//			mv.addObject("EmployeeList",dao.findAll(PageRequest.of(0, hh)).getContent());
//		}else {
//			int i = length/hh;
//			if(i*hh==length) {
//				for (int j=0;j<=i;j++) {
//					mv.addObject("EmployeeList",dao.findAll(PageRequest.of(j, hh)).getContent());
//				}
//			}else {
//				for (int j=0;j<=i+1;j++) {
//					mv.addObject("EmployeeList",dao.findAll(PageRequest.of(j, hh)).getContent());
//				}
//			}
//		}
		mv.addObject("EmployeeList",dao.findAll(PageRequest.of(pageno, qw)).getContent());
		mv.addObject("pagesize",qw);
		mv.addObject("totalrecords",((List<Employ>) dao.findAll()).size());
		
		mv.setViewName("home");
		return mv;
		
	}
}
