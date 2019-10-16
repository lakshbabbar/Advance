package com.hcl.AdvanceSpring;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployRepository extends PagingAndSortingRepository<Employ,Integer> {

	@Query("SELECT e from Employ e Where dept = ?1 And desig= ?2")
	List<Employ> findByDeptAndDesig(String department,String designation); 
	
	@Query("Select e from Employ e where dept = ?1 and desig= ?2 and basic>50000")
	List<Employ> findByDeptDesigAndBasic(String department,String designation);
	
	@Query("Select e from Employ e where basic<25000 and name Like 'b%'")
	List<Employ> findByBasicAndPattern(Sort sort);
	
	List<Employ> findByDeptAndDesig(String department,String designation,Sort sort); 

}
