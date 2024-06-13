package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>,CustomRepository{

	public Employee findById(int id);
	
	@Query(value = "select * from employee_table where emp_name=:n", nativeQuery = true)
	public Employee findByemp_name(@Param("n")String name);
	
	
	@Query(value = "SELECT e.* FROM employee_table e INNER JOIN department_table d"
			+ " ON e.department_id = d.department_id WHERE d.department_name=:n",
			nativeQuery = true)
	public List<Employee> findByDepartment(@Param("n")String name);
	
	
	
}
