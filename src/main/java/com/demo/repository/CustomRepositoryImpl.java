package com.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.entities.Department;
import com.demo.entities.Employee;
import com.demo.entities.Project_Manager;
import com.demo.entities.Vice_President;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CustomRepositoryImpl implements CustomRepository{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findByNameAndDepartment(String name) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery cq = cb.createQuery();
		Root<Employee> employee = cq.from(Employee.class);
		Predicate fname = cb.equal(employee.get("emp_name"), name);
		cq.where(fname);
		TypedQuery<Employee> query = entityManager.createQuery(cq);
	
		return query.getResultList();
	}

	@Override
	public List<Employee> findBySomeString(String str) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> employee = cq.from(Employee.class);
		
		Join<Employee, Department> department = employee.join("department");
		Join<Employee, Project_Manager> manager = employee.join("pmanager");
		Join<Project_Manager,Vice_President> president = manager.join("vicepresident");
		Predicate departmentNamePredicate = cb.like(department.get("department_name"), "%"+str+"%");
		Predicate managerPredicate = cb.like(manager.get("manager_name"), "%"+str+"%");
		Predicate vpresident = cb.like(president.get("vicepresident_name"), "%"+str+"%");
		Predicate finalPredicate = cb.or(departmentNamePredicate, managerPredicate,vpresident);
		cq.select(employee).where(finalPredicate);
		List<Employee> employees = entityManager.createQuery(cq).getResultList();
		return employees;
	}

	@Override
	public List<Employee> findByAnyString(String str) {
		System.out.println("running...");
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> employee = cq.from(Employee.class);
		
		Predicate p = cb.or(
				cb.like(employee.get("emp_name"), "%" + str + "%"),
				cb.like(employee.get("department"), "%" + str + "%"),
				cb.like(employee.get("pmanager"), "%" + str + "%")
				);
		cq.where(p);
		List<Employee> employees = entityManager.createQuery(cq).getResultList();
				
		
		return employees;
	}
	
	public List<Employee> findByDprtName(String name)
	{
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> employee = cq.from(Employee.class);
		Join<Employee, Department> join  = employee.join("department");
		Predicate dprtp = cb.equal(join.get("department_name"),name);

//		cq.select(employee).where(dprtp);

		List<Employee> employees = entityManager.createQuery(cq.select(employee).where(dprtp)).getResultList();
		return employees;
		
	}

	@Override
	public List<Employee> findByAnyNumber(int number) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class); 
		Root<Employee> employee = cq.from(Employee.class);
	
		Join<Employee, Project_Manager> manager = employee.join("pmanager");
		Predicate employeePredicate = cb.equal(employee.get("emp_age"), number);
		Predicate employeePredicate1 = cb.equal(employee.get("emp_experience"), number);
		Predicate managerPredicate = cb.equal(manager.get("manager_experience"), number);
		Predicate finalPredicate = cb.or(employeePredicate,employeePredicate1, managerPredicate);
		cq.select(employee).where(finalPredicate);
		List<Employee> employees = entityManager.createQuery(cq).getResultList();
		return employees;
	}

}
