package com.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "employee_table")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int emp_id;
	
	@NotBlank
	private String emp_name;
	
	@Email
	private String emp_email;
	
	@Min (value = 18)
	@Max (value = 65)
	private int emp_age;
	
	private int emp_experience;
	
	@NotBlank
	@Size (min = 8, max = 10)
	private String password;
	
	@ManyToOne
	@JoinColumn(name="manager_id")
	@JsonIgnoreProperties({"employees"})
	private Project_Manager pmanager; 
	
	@ManyToOne
	@JoinColumn(name="department_id")
	@JsonIgnoreProperties("employees")
	private Department department;

	public Employee() {
		super();

	}

	public Employee(int emp_id, String emp_name, String emp_email, int emp_age, int emp_experience,
			String password,Project_Manager pmanager, Department department) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_age = emp_age;
		this.emp_experience = emp_experience;
		this.password = password;
		this.pmanager = pmanager;
		this.department = department;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public int getEmp_age() {
		return emp_age;
	}

	public void setEmp_age(int emp_age) {
		this.emp_age = emp_age;
	}

	public int getEmp_experience() {
		return emp_experience;
	}

	public void setEmp_experience(int emp_experience) {
		this.emp_experience = emp_experience;
	}

	public Project_Manager getPmanager() {
		return pmanager;
	}

	public void setPmanager(Project_Manager pmanager) {
		this.pmanager = pmanager;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_email=" + emp_email + ", emp_age="
				+ emp_age + ", emp_experience=" + emp_experience + ", pmanager=" + pmanager + ", department="
				+ department + "]";
	}
	
	
	

	

}
