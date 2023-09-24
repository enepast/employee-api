package com.employee.api.employeeapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.api.employeeapi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}
