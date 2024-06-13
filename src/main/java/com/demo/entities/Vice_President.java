package com.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "vicepresident_table")
public class Vice_President {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vicepresident_id;
	private String vicepresident_name;
	
	@OneToMany
	@JoinColumn(name="vicepresident")
	@JsonIgnoreProperties("vicepresident")
	private List<Project_Manager> managers;
	


	public Vice_President() {
		super();

	}



	public Vice_President(int vicepresident_id, String vicepresident_name, List<Project_Manager> managers) {
		super();
		this.vicepresident_id = vicepresident_id;
		this.vicepresident_name = vicepresident_name;
		this.managers = managers;
	}



	public int getVicepresident_id() {
		return vicepresident_id;
	}



	public void setVicepresident_id(int vicepresident_id) {
		this.vicepresident_id = vicepresident_id;
	}



	public String getVicepresident_name() {
		return vicepresident_name;
	}



	public void setVicepresident_name(String vicepresident_name) {
		this.vicepresident_name = vicepresident_name;
	}



	public List<Project_Manager> getManagers() {
		return managers;
	}



	public void setManagers(List<Project_Manager> managers) {
		this.managers = managers;
	}



	@Override
	public String toString() {
		return "Vice_President [vicepresident_id=" + vicepresident_id + ", vicepresident_name=" + vicepresident_name
				+ ", managers=" + managers + "]";
	}



}
