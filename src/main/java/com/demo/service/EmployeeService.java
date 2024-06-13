package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.entities.Department;
import com.demo.entities.Employee;
import com.demo.entities.Project_Manager;
import com.demo.entities.Vice_President;
import com.demo.repository.DepartmentRepository;
import com.demo.repository.EmployeeRepository;
import com.demo.repository.ManagerRepository;
import com.demo.repository.VicePresidentRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRespository;
	@Autowired
	private ManagerRepository managerRepository;
	@Autowired
	private VicePresidentRepository vicepresidentRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Employee> getAllEmployees()
	{
		List<Employee> list = (List<Employee>) employeeRespository.findAll();
		return list;
	}
	
	public Employee getEmployeeById(int id)
	{
		return employeeRespository.findById(id);
	}
	
	@Transactional
	public void addEmployee(Employee employee)
	{
		employeeRespository.save(employee);
		System.out.println(employee);
		Project_Manager manager = employee.getPmanager();
		System.out.println(manager);
		managerRepository.save(manager);
		
		Department department = employee.getDepartment();
		System.out.println(department);
		departmentRepository.save(department);
		
		Vice_President vicepresident = manager.getVicepresident();
		System.out.println(vicepresident);
		
		if(vicepresident.getManagers()==null)
		{
			vicepresident.setManagers(new ArrayList<>());
		}
		vicepresident.getManagers().add(manager);
		vicepresidentRepository.save(vicepresident);
		
	}
	
	public void deleteEmployeeById(int id)
	{
		System.out.println(id);
		employeeRespository.deleteById(id);
	}
	
	public Employee updateEmployeeById(Employee employee,int id)
	{
		employee.setEmp_id(id);
		return employeeRespository.save(employee);
	}
	
	
	//CustomRepository methods
	public Employee getEmployeeByName(String name)
	{
		return employeeRespository.findByemp_name(name);
	}
	
	public List<Employee> getEmployeeByDepartmentName(String name)
	{
		System.out.println(name);
		return employeeRespository.findByDepartment(name);
	}
	
	public List<Employee> findByNameAndDepartment(String name) {
		
		return employeeRespository.findByNameAndDepartment(name);
	
	}
	
	public List<Employee> findBySomeString(String name)
	{
		return employeeRespository.findBySomeString(name);
	}
	
	public List<Employee> findByAnyString(String str) {
	
		return employeeRespository.findByAnyString(str);
	}
	
	public List<Employee> findByDprtName(String name)
	{
		return employeeRespository.findByDprtName(name);
	}
	
	public List<Employee> findByAnyNumber(int number) {
		
		return employeeRespository.findByAnyNumber(number);
	}
	
	

}
