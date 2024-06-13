package com.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "manager_table")
public class Project_Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int manager_id;
	private String manager_name;
	private int manager_experience;

	@ManyToOne
	@JsonIgnoreProperties("managers")
	private Vice_President vicepresident;

	@OneToMany
	@JsonIgnoreProperties("pmanager")
	private List<Employee> employees;

	public Project_Manager() {
		super();

	}

	public Project_Manager(int manager_id, String manager_name, int manager_experience, Vice_President vicepresident,
			List<Employee> employees) {
		super();
		this.manager_id = manager_id;
		this.manager_name = manager_name;
		this.manager_experience = manager_experience;
		this.vicepresident = vicepresident;
		this.employees = employees;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public int getManager_experience() {
		return manager_experience;
	}

	public void setManager_experience(int manager_experience) {
		this.manager_experience = manager_experience;
	}

	public Vice_President getVicepresident() {
		return vicepresident;
	}

	public void setVicepresident(Vice_President vicepresident) {
		this.vicepresident = vicepresident;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project_Manager [manager_id=" + manager_id + ", manager_name=" + manager_name + ", manager_experience="
				+ manager_experience + ", vicepresident=" + vicepresident + ", employees=" + employees + "]";
	}

}
