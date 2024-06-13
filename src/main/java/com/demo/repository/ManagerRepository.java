package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Project_Manager;

public interface ManagerRepository extends JpaRepository<Project_Manager, Integer>{

}
