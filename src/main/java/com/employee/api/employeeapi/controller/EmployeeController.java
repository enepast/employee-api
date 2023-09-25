package com.employee.api.employeeapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.api.employeeapi.model.Employee;
import com.employee.api.employeeapi.services.EmployeeServices;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private final EmployeeServices employeeServices;
	
	public EmployeeController(EmployeeServices employeeServices) {
		this.employeeServices = employeeServices;
	}
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee){
		return employeeServices.createEmployee(employee);		
	}
	
	@GetMapping
	public List<Employee> getEmployees() {
		return employeeServices.getAll();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
		return employeeServices.getEmployee(id);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable("id") int id, Employee employee) {
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable("id") int id) {
		employeeServices.deleteEmployee(id);
	}
	
}
