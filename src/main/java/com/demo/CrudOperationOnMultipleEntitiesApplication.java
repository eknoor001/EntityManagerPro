package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudOperationOnMultipleEntitiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudOperationOnMultipleEntitiesApplication.class, args);
	}

}
/*
 * 
 *  {
	  "emp_name": "John Doe",
	  "emp_email": "john.doe@example.com",
	  "emp_age": 30,
	  "emp_experience": 5,
	  "pmanager": {
	    "manager_name": "Jane Smith",
	    "manager_experience": 10,
        "vicepresident":
        {
            "vicepresident_name": "Robert Johnson",
            "managers": []
        }
	  },
	  "department": {
	    "department_name": "IT"
	  }
	}
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
{
	  "emp_name": "John Doe",
	  "emp_email": "john.doe@example.com",
	  "emp_age": 30,
	  "emp_experience": 5,
	  "pmanager": {
	    "manager_name": "Jane Smith",
	    "manager_experience": 10
	  },
	  "department": {
	    "department_name": "IT"
	  }
	}
	//////////////////////////////////////
	 {
  "manager_name": "Jane Smith",
  "manager_experience": 10,
  "vicepresident": {
    "vp_name": "Robert Johnson",
    "vp_experience": 15
  },
  "employees": []
} 

////////////////////
 {
  "department_name": "IT",
  "employees": []
}

{
  "vicepresident_name": "Robert Johnson",
  "managers": []
}
	 */
