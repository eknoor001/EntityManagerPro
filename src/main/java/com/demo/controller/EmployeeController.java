package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Employee;
import com.demo.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employeesdata")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> list = (List<Employee>) employeeService.getAllEmployees();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
        Employee emp = employeeService.getEmployeeById(id);
        if (emp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(emp);
    }

    @PostMapping("/employeesdata")
    public void addEmployee(@Valid @RequestBody Employee employee) {
        System.out.println(employee);
        employeeService.addEmployee(employee);
    }

    @DeleteMapping("/employeesdata/{id}")
    public void deleteEmployeeById(@PathVariable("id") int id) {
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/employeesdata/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee, @PathVariable("id") int id) {
        employee.setEmp_id(id);
        Employee emp = employeeService.updateEmployeeById(employee, id);
        if (emp == null) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        return ResponseEntity.ok(emp);
    }

    //no need
    @GetMapping("/employeesdata/{name}")
    public ResponseEntity<Employee> getEmployeeByName(@PathVariable("name") String name) {
        Employee emp = employeeService.getEmployeeByName(name);
        if (emp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(emp);
    }

    //no need
    @GetMapping("/employeedatadprt/{name}")
    public List<Employee> getEmployeeByDepartmentName(@PathVariable("name") String name) {

        List<Employee> list = employeeService.getEmployeeByDepartmentName(name);

        return list;
    }

    @GetMapping("/employeesname/{name}")
    public List<Employee> findByNameAndDepartment(@PathVariable("name") String name) {

        return employeeService.findByNameAndDepartment(name);

    }

    @GetMapping("/anyname/{name}")
    public List<Employee> findBySomeString(@PathVariable("name") String name) {
        return employeeService.findBySomeString(name);
    }

    @GetMapping("/anystring/{str}")
    public List<Employee> findByAnyString(@PathVariable("str") String str) {
        return employeeService.findByAnyString(str);
    }

    @GetMapping("/employeebydprtname/{name}")
    public List<Employee> findByDprtName(@PathVariable("name") String name) {
        return employeeService.findByDprtName(name);
    }

    @GetMapping("/databyanynumber/{number}")
    public List<Employee> findByAnyNumber(@PathVariable("number") int number) {

        return employeeService.findByAnyNumber(number);
    }
}
