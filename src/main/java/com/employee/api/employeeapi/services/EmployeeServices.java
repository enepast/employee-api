package com.employee.api.employeeapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.api.employeeapi.model.Employee;
import com.employee.api.employeeapi.repositories.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServices{
	
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServices(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Transactional
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee getEmployee(int id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	public void updateEmployee(Employee employee, int id) {
		Employee employeeToUpdate = employeeRepository.findById(id).orElse(null);
		if(employeeToUpdate != null) {
			employeeToUpdate.setFirstName(employee.getFirstName());
			employeeToUpdate.setLastName(employee.getLastName());
			employeeToUpdate.setEmail(employee.getEmail());
			
			employeeRepository.save(employeeToUpdate);
		} else System.out.println("There's no employee with that id");
		
		return;
	}
	
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

}
