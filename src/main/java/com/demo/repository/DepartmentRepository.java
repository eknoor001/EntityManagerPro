package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
