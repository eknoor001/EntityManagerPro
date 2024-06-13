package com.demo.repository;

import java.util.List;

import com.demo.entities.Employee;

public interface CustomRepository {

//	List<Employee> findByNameAndDepartment(String name, String dprt);

	List<Employee> findByNameAndDepartment(String name);
	
	List<Employee> findBySomeString(String str);
	
	List<Employee> findByAnyString(String str);
	
    List<Employee> findByDprtName(String name);
    
    List<Employee> findByAnyNumber(int number);
	
	
	
}
